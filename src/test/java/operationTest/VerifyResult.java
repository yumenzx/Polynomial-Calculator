package operationTest;

import mvc.models.Monomial;
import mvc.models.Polynomial;

public abstract class VerifyResult {

    public static boolean verify(Polynomial p1, Polynomial p2) {
        if (p1.getPolinom().size() != p2.getPolinom().size())
            return false;

        int nrElementeDiferite = 0;
        for (Monomial m1 : p1.getPolinom()) {
            int nrMonoameEgale = 0;
            for (Monomial m2 : p2.getPolinom()) {
                if (m1.getExponent() == m2.getExponent()) {
                    if (m1.getCoeficient() != m2.getCoeficient())
                        return false;
                    else
                        nrMonoameEgale++;
                } else
                    nrElementeDiferite++;
            }
            if (nrMonoameEgale != 1)
                return false;
        }

        return nrElementeDiferite == p1.getPolinom().size() * (p1.getPolinom().size() - 1);
    }

}
