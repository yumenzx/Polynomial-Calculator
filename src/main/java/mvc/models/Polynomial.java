package mvc.models;

import java.util.ArrayList;
import java.util.List;


public class Polynomial {

    private List<Monomial> polinom;


    public Polynomial() {
        polinom = new ArrayList<>();
    }

    public List<Monomial> getPolinom() {
        return polinom;
    }


    private void groupTerms() {
        for (Monomial m1 : polinom) {
            for (Monomial m2 : polinom) {
                if (m1 != m2 && m1.getExponent() == m2.getExponent()) {
                    m1.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
                    m2.setCoeficient(0);
                }
            }
        }

        polinom.removeIf(m -> m.getCoeficient() == 0);

        polinom.sort(new PowerComparator());
    }


    public Polynomial add(Polynomial p) {

        Polynomial result = new Polynomial();

        for (Monomial m : polinom) {
            result.getPolinom().add(new Monomial(m.getCoeficient(), m.getExponent()));
        }
        if (p != null && p.getPolinom() != null) {
            for (Monomial m : p.getPolinom()) {
                result.getPolinom().add(new Monomial(m.getCoeficient(), m.getExponent()));
            }
        }

        result.groupTerms();

        return result;
    }

    public Polynomial substract(Polynomial p) {

        Polynomial result = new Polynomial();

        for (Monomial m : polinom) {
            result.getPolinom().add(new Monomial(m.getCoeficient(), m.getExponent()));
        }
        if (p != null && p.getPolinom() != null) {
            for (Monomial m : p.getPolinom()) {
                result.getPolinom().add(new Monomial(-m.getCoeficient(), m.getExponent()));
            }
        }

        result.groupTerms();

        return result;
    }

    public Polynomial multiply(Polynomial p) {

        Polynomial result = new Polynomial();

        if (p == null)
            return null;

        for (Monomial m1 : polinom) {
            for (Monomial m2 : p.getPolinom()) {
                result.getPolinom().add(new Monomial(m1.getCoeficient() * m2.getCoeficient(), m1.getExponent() + m2.getExponent()));
            }
        }

        result.groupTerms();

        return result;
    }

    public CalculatedDivision divide(Polynomial p) throws ArithmeticException {

        if (p.getPolinom().size() == 0)
            throw new ArithmeticException("Division by polynomial 0");

        Polynomial cat = new Polynomial();
        Polynomial rest = add(null);

        this.groupTerms();
        p.groupTerms();

        // prima conditie din while este pusa pt ca la final sa poate intampla ca restul sa fie polinomul 0
        while (rest.getPolinom().size() > 0 && rest.getPolinom().get(0).getExponent() >= p.getPolinom().get(0).getExponent()) {

            double coeficient = rest.getPolinom().get(0).getCoeficient() / p.getPolinom().get(0).getCoeficient();
            int exponent = rest.getPolinom().get(0).getExponent() - p.getPolinom().get(0).getExponent();

            Monomial currentMonomial = new Monomial(coeficient, exponent);
            Polynomial currentPolynomial = new Polynomial();

            cat.getPolinom().add(currentMonomial); // se adauga monomul curent la cat
            currentPolynomial.getPolinom().add(currentMonomial); // se face un polinom din monomul curent

            rest = rest.substract(currentPolynomial.multiply(p));
        }

        return new CalculatedDivision(cat, rest);
    }

    public Polynomial derivate() {

        Polynomial result = new Polynomial();

        this.groupTerms();

        for (Monomial m : polinom) {
            if (m.getExponent() != 0)
                result.getPolinom().add(new Monomial(m.getCoeficient() * m.getExponent(), m.getExponent() - 1));
        }

        return result;
    }

    public Polynomial integrate() {

        Polynomial result = new Polynomial();

        this.groupTerms();

        for (Monomial m : polinom) {
            result.getPolinom().add(new Monomial(Double.parseDouble(String.format("%.2f", m.getCoeficient() / (m.getExponent() + 1))), m.getExponent() + 1));
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for (Monomial m : polinom) {
            double coeficient = Double.parseDouble(String.format("%.2f", m.getCoeficient()));
            switch (m.getExponent()) {
                case 0:
                    result += coeficient > 0 ? "+" + coeficient : coeficient;
                    break;
                case 1:
                    if (coeficient == -1)
                        result += "-X";
                    else if (coeficient == 1)
                        result += "+X";
                    else
                        result += (coeficient > 0 ? "+" + coeficient : coeficient) + "X";
                    break;
                default:
                    if (coeficient == -1)
                        result += "-X^" + m.getExponent();
                    else if (coeficient == 1)
                        result += "+X^" + m.getExponent();
                    else
                        result += (coeficient > 0 ? "+" + coeficient : coeficient) + "X^" + m.getExponent();
            }
            result += " ";
        }
        return result.equals("") ? "0" : result;
    }
}