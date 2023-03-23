package operationTest;

import mvc.models.Monomial;
import mvc.models.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrateOperationTest {

    @Test
    public void integrateTest() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(1, 3));
        p1.getPolinom().add(new Monomial(4, 2));
        p1.getPolinom().add(new Monomial(5, 0));

        Polynomial result = p1.integrate();

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(0.25, 4));
        expectedResult.getPolinom().add(new Monomial(1.33, 3));
        expectedResult.getPolinom().add(new Monomial(5, 1));

        assertTrue(VerifyResult.verify(result, expectedResult));
    }

    @Test
    public void integrateTest2() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(3, 2));
        p1.getPolinom().add(new Monomial(4, 1));
        p1.getPolinom().add(new Monomial(-2, 0));

        Polynomial result = p1.integrate();

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(1, 3));
        expectedResult.getPolinom().add(new Monomial(2, 2));
        expectedResult.getPolinom().add(new Monomial(-2, 1));

        assertTrue(VerifyResult.verify(result, expectedResult));
    }
}
