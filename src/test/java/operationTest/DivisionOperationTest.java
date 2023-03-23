package operationTest;

import mvc.models.CalculatedDivision;
import mvc.models.Monomial;
import mvc.models.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DivisionOperationTest {

    @Test
    public void divisionTest() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(1, 3));
        p1.getPolinom().add(new Monomial(-2, 2));
        p1.getPolinom().add(new Monomial(6, 1));
        p1.getPolinom().add(new Monomial(-5, 0));
        Polynomial p2 = new Polynomial();
        p2.getPolinom().add(new Monomial(1, 2));
        p2.getPolinom().add(new Monomial(-1, 0));

        CalculatedDivision result = p1.divide(p2);

        Polynomial cat = new Polynomial();
        cat.getPolinom().add(new Monomial(1,1));
        cat.getPolinom().add(new Monomial(-2,0));
        Polynomial rest = new Polynomial();
        rest.getPolinom().add(new Monomial(7,1));
        rest.getPolinom().add(new Monomial(-7,0));

        CalculatedDivision expectedResult = new CalculatedDivision(cat,rest);

        assertTrue(VerifyResult.verify(result.getCat(),expectedResult.getCat())&&VerifyResult.verify(result.getRest(), expectedResult.getRest()));
    }

    @Test
    public void divisionTest2() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(1, 4));
        p1.getPolinom().add(new Monomial(-1, 3));
        p1.getPolinom().add(new Monomial(2, 2));
        p1.getPolinom().add(new Monomial(-1, 1));
        p1.getPolinom().add(new Monomial(3, 0));
        Polynomial p2 = new Polynomial();
        p2.getPolinom().add(new Monomial(1, 1));
        p2.getPolinom().add(new Monomial(-1, 0));

        CalculatedDivision result = p1.divide(p2);

        Polynomial cat = new Polynomial();
        cat.getPolinom().add(new Monomial(1,3));
        cat.getPolinom().add(new Monomial(2,1));
        cat.getPolinom().add(new Monomial(1,0));
        Polynomial rest = new Polynomial();
        rest.getPolinom().add(new Monomial(4,0));

        CalculatedDivision expectedResult = new CalculatedDivision(cat,rest);

        assertTrue(VerifyResult.verify(result.getCat(),expectedResult.getCat())&&VerifyResult.verify(result.getRest(), expectedResult.getRest()));
    }
}
