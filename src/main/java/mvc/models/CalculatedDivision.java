package mvc.models;

public class CalculatedDivision {

    private Polynomial cat;
    private Polynomial rest;


    public CalculatedDivision(Polynomial cat, Polynomial rest) {
        this.cat = cat;
        this.rest = rest;
    }


    public Polynomial getCat() {
        return cat;
    }

    public Polynomial getRest() {
        return rest;
    }

}