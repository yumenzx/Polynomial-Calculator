package mvc.models;

import java.util.Comparator;

public class PowerComparator implements Comparator<Monomial> {

    @Override
    public int compare(Monomial m1, Monomial m2) {
        return Integer.compare(m2.getExponent(), m1.getExponent());
    }

}
