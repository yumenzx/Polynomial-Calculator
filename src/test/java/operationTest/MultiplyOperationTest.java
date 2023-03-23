package operationTest;

import mvc.models.Monomial;
import mvc.models.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplyOperationTest {

    @Test
    public void multiplyTest() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(3, 2));
        p1.getPolinom().add(new Monomial(-1, 1));
        p1.getPolinom().add(new Monomial(1, 0));
        Polynomial p2 = new Polynomial();
        p2.getPolinom().add(new Monomial(1, 1));
        p2.getPolinom().add(new Monomial(-2, 0));

        Polynomial result = p1.multiply(p2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(3, 3));
        expectedResult.getPolinom().add(new Monomial(-7, 2));
        expectedResult.getPolinom().add(new Monomial(3, 1));
        expectedResult.getPolinom().add(new Monomial(-2, 0));

        assertTrue(VerifyResult.verify(result, expectedResult));
    }

    @Test
    public void multiplyTest2() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(1, 2));
        p1.getPolinom().add(new Monomial(1, 1));
        p1.getPolinom().add(new Monomial(1, 0));
        Polynomial p2 = new Polynomial();
        p2.getPolinom().add(new Monomial(1, 1));
        p2.getPolinom().add(new Monomial(-1, 0));

        Polynomial result = p1.multiply(p2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(1, 3));
        expectedResult.getPolinom().add(new Monomial(-1, 0));

        assertTrue(VerifyResult.verify(result, expectedResult));
    }
}
