package mvc.models;

public class Monomial {

    private double coeficient;
    private int exponent;


    public Monomial(double coeficient, int exponent) {
        this.coeficient = coeficient;
        this.exponent = exponent;
    }


    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

}
