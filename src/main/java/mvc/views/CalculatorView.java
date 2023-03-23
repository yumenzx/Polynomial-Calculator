package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame{

    private JTextField polinom1Field;
    private JTextField polinom2Field;
    private JTextField resultField;

    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton derivateButton;
    private JButton integrateButton;
    private JButton clearButton;
    private JButton exitButton;


    public CalculatorView() {
        this.setBounds(100, 100, 562, 296);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel title = new JLabel("Polynomial Calculator");
        title.setBounds(175, 10, 219, 40);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        this.getContentPane().add(title);

        JLabel text1 = new JLabel("First Polynomial:");
        text1.setBounds(29, 67, 125, 25);
        text1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(text1);

        JLabel text2 = new JLabel("Second Polynomial:");
        text2.setBounds(10, 102, 144, 25);
        text2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(text2);

        polinom1Field = new JTextField();
        polinom1Field.setBounds(153, 67, 385, 25);
        polinom1Field.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.getContentPane().add(polinom1Field);
        polinom1Field.setColumns(10);

        polinom2Field = new JTextField();
        polinom2Field.setBounds(153, 102, 385, 25);
        polinom2Field.setFont(new Font("Tahoma", Font.PLAIN, 14));
        polinom2Field.setColumns(10);
        this.getContentPane().add(polinom2Field);

        JLabel lblResult = new JLabel("Result:");
        lblResult.setBounds(88, 148, 65, 25);
        lblResult.setFont(new Font("Tahoma", Font.BOLD, 16));
        this.getContentPane().add(lblResult);

        resultField = new JTextField();
        resultField.setBounds(153, 148, 385, 25);
        resultField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resultField.setColumns(10);
        this.getContentPane().add(resultField);

        addButton = new JButton("Add");
        addButton.setBounds(175, 183, 104, 29);
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(addButton);

        substractButton = new JButton("Substract");
        substractButton.setBounds(175, 210, 104, 29);
        substractButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(substractButton);

        multiplyButton = new JButton("Multiply");
        multiplyButton.setBounds(289, 183, 104, 29);
        multiplyButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(multiplyButton);

        divisionButton = new JButton("Division");
        divisionButton.setBounds(289, 210, 104, 29);
        divisionButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(divisionButton);

        derivateButton = new JButton("Derivate");
        derivateButton.setBounds(403, 183, 104, 29);
        derivateButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(derivateButton);

        integrateButton = new JButton("Integrate");
        integrateButton.setBounds(403, 210, 104, 28);
        integrateButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(integrateButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        clearButton.setBounds(42, 187, 79, 25);
        this.getContentPane().add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        exitButton.setBounds(42, 214, 79, 25);
        this.getContentPane().add(exitButton);

        this.setTitle("Polynomial Calculator");
        this.setVisible(true);
    }


    public String getPolinom1Field() {
        return polinom1Field.getText();
    }

    public String getPolinom2Field() {
        return polinom2Field.getText();
    }

    public void setResultField(String resultField) {
        this.resultField.setText(resultField);
    }


    public void addAddButtonListener(ActionListener action) {
        addButton.addActionListener(action);
    }

    public void addSubstractButtonListener(ActionListener action) {
        substractButton.addActionListener(action);
    }

    public void addMultiplyButtonListener(ActionListener action) {
        multiplyButton.addActionListener(action);
    }

    public void addDivisionButtonListener(ActionListener action) {
        divisionButton.addActionListener(action);
    }

    public void addDerivateButtonListener(ActionListener action) {
        derivateButton.addActionListener(action);
    }

    public void addIntegrateButtonListener(ActionListener action) {
        integrateButton.addActionListener(action);
    }

    public void addClearButtonListener(ActionListener action) {
        clearButton.addActionListener(action);
    }

    public void addExitButtonListener(ActionListener action) {
        exitButton.addActionListener(action);
    }


    public void clearFields() {
        polinom1Field.setText("");
        polinom2Field.setText("");
        resultField.setText("");
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.INFORMATION_MESSAGE);
    }
}
