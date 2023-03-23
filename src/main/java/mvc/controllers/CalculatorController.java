package mvc.controllers;

import mvc.models.CalculatedDivision;
import mvc.models.Monomial;
import mvc.models.Polynomial;
import mvc.views.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {

    private Polynomial polinom1; // model1
    private Polynomial polinom2; // model2
    private CalculatorView view;

    public CalculatorController(Polynomial polinom1, Polynomial polinom2, CalculatorView view) {
        this.polinom1 = polinom1;
        this.polinom2 = polinom2;
        this.view = view;

        this.view.addAddButtonListener(new AddListener());
        this.view.addSubstractButtonListener(new SubstractListener());
        this.view.addMultiplyButtonListener(new MultiplyListener());
        this.view.addDivisionButtonListener(new DivisionListener());
        this.view.addDerivateButtonListener(new DerivateListener());
        this.view.addIntegrateButtonListener(new IntegrateListener());
        this.view.addClearButtonListener(new ClearListener());
        this.view.addExitButtonListener(new ExitListener());
    }


    private boolean verifyInput(String input) {
        for (Character c : input.toCharArray()) {
            if (!"1234567890X^+-".contains(c.toString()))
                return false;
        }
        return true;
    }

    private int getCoeficient(String input) throws Exception {
        int coeficient = 0;

        if (input == null)
            return 1;
        else
            coeficient = switch (input) {
                case "", "+" -> 1;
                case "-" -> -1;
                default -> Integer.parseInt(input);
            };

        return coeficient;
    }

    private int getExponent(String variabila, String exponent) throws Exception {
        int putere = 0;

        switch (variabila) {
            case "X^" -> {
                if (exponent.equals(""))
                    throw new Exception("Lipsa exponent la: " + variabila);
                putere = Integer.parseInt(exponent);
                if (putere < 0)
                    throw new Exception("Puterea exponentului nu poate sa fie negativa");
            }
            case "X" -> putere = 1;
            case "" -> putere = 0;
            default -> throw new Exception("Format invalid pentru: " + variabila);
        }

        return putere;
    }

    private void getFields(Polynomial p, int n) throws Exception {

        String field = n == 1 ? view.getPolinom1Field() : view.getPolinom2Field();

        field = field.replaceAll(" ", "").toUpperCase();

        if (!verifyInput(field))
            throw new Exception("Polinomul introdus contine caractere nedefinite");

        Pattern pattern = Pattern.compile("([+-]*[0-9]*)(X[0-9]+|[A-Z]*\\^*)([0-9]*)");
        Matcher m = pattern.matcher(field);

        while (m.find()) {
            if (!m.group(0).equals("")) {
                int coeficient;
                int putere;

                try {
                    coeficient = getCoeficient(String.valueOf(m.group(1)));
                    if (m.group(2) != null) {
                        putere = getExponent(String.valueOf(m.group(2)), String.valueOf(m.group(3)));
                        p.getPolinom().add(new Monomial(coeficient, putere));
                    }
                } catch (Exception e) {
                    view.showMessage(e.getMessage());
                }
            }
        }
    }


    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getFields(polinom1, 1);
                getFields(polinom2, 2);
            } catch (Exception ex) {
                view.showMessage(ex.getMessage());
            }

            Polynomial result = polinom1.add(polinom2);
            view.setResultField(result.toString());

            polinom1.getPolinom().clear();
            polinom2.getPolinom().clear();
        }
    }

    class SubstractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getFields(polinom1, 1);
                getFields(polinom2, 2);
            } catch (Exception ex) {
                view.showMessage("Eroare: " + ex.getMessage());
            }

            Polynomial result = polinom1.substract(polinom2);
            view.setResultField(result.toString());

            polinom1.getPolinom().clear();
            polinom2.getPolinom().clear();
        }
    }

    class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getFields(polinom1, 1);
                getFields(polinom2, 2);
            } catch (Exception ex) {
                view.showMessage("Eroare: " + ex.getMessage());
            }

            Polynomial result = polinom1.multiply(polinom2);
            view.setResultField(result.toString());

            polinom1.getPolinom().clear();
            polinom2.getPolinom().clear();
        }
    }

    class DivisionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getFields(polinom1, 1);
                getFields(polinom2, 2);
            } catch (Exception ex) {
                view.showMessage("Eroare: " + ex.getMessage());
            }

            try {
                CalculatedDivision result = polinom1.divide(polinom2);
                view.setResultField("Catul: " + result.getCat().toString() + "  Rest: " + result.getRest().toString());
            } catch (Exception exception) {
                view.showMessage("Introduceti un polinom diferit de polinomul 0");
            }

            polinom1.getPolinom().clear();
            polinom2.getPolinom().clear();
        }
    }

    class DerivateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getFields(polinom1, 1);
                if (!view.getPolinom2Field().replaceAll(" ", "").equals(""))
                    view.showMessage("Doar pentru primul polinom introdus se va efectua operatia");
            } catch (Exception ex) {
                view.showMessage(ex.getMessage());
            }

            Polynomial result = polinom1.derivate();
            view.setResultField(result.toString());

            polinom1.getPolinom().clear();
        }
    }

    class IntegrateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getFields(polinom1, 1);
                if (!view.getPolinom2Field().replaceAll(" ", "").equals(""))
                    view.showMessage("Doar pentru primul polinom introdus se va efectua operatia");
            } catch (Exception ex) {
                view.showMessage("Eroare: " + ex.getMessage());
            }

            Polynomial result = polinom1.integrate();
            view.setResultField(result.toString() + " +C");

            polinom1.getPolinom().clear();
        }

    }

    class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearFields();
        }
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }
}