package mvc;

import mvc.controllers.CalculatorController;
import mvc.models.Polynomial;
import mvc.views.CalculatorView;


public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        CalculatorView view = new CalculatorView();
        new CalculatorController(p1,p2,view);
    }
}
