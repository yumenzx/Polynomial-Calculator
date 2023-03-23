package operationTest;

import mvc.models.Monomial;
import mvc.models.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DerivateOperationTest {

    @Test
    public void derivateTest() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(1, 3));
        p1.getPolinom().add(new Monomial(-2, 2));
        p1.getPolinom().add(new Monomial(6, 1));
        p1.getPolinom().add(new Monomial(-5, 0));

        Polynomial result = p1.derivate();

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(3, 2));
        expectedResult.getPolinom().add(new Monomial(-4, 1));
        expectedResult.getPolinom().add(new Monomial(6, 0));

        assertTrue(VerifyResult.verify(result, expectedResult));
    }

    @Test
    public void derivateTest2() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(1, 6));
        p1.getPolinom().add(new Monomial(-2, 4));
        p1.getPolinom().add(new Monomial(-3, 2));
        p1.getPolinom().add(new Monomial(3, 1));
        p1.getPolinom().add(new Monomial(-1, 0));

        Polynomial result = p1.derivate();

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(6, 5));
        expectedResult.getPolinom().add(new Monomial(-8, 3));
        expectedResult.getPolinom().add(new Monomial(-6, 1));
        expectedResult.getPolinom().add(new Monomial(3, 0));

        assertTrue(VerifyResult.verify(result, expectedResult));
    }
}