package operationTest;

import mvc.models.Monomial;
import mvc.models.Polynomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddOperationTest {

    @Test
    public void addTest() {
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(4, 5));
        p1.getPolinom().add(new Monomial(-3, 4));
        p1.getPolinom().add(new Monomial(1, 2));
        p1.getPolinom().add(new Monomial(-8, 1));
        p1.getPolinom().add(new Monomial(1, 0));
        Polynomial p2 = new Polynomial();
        p2.getPolinom().add(new Monomial(3, 4));
        p2.getPolinom().add(new Monomial(-1, 3));
        p2.getPolinom().add(new Monomial(1, 2));
        p2.getPolinom().add(new Monomial(2, 1));
        p2.getPolinom().add(new Monomial(-1, 0));

        Polynomial result = p1.add(p2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(4, 5));
        expectedResult.getPolinom().add(new Monomial(-1, 3));
        expectedResult.getPolinom().add(new Monomial(2, 2));
        expectedResult.getPolinom().add(new Monomial(-6, 1));


        assertTrue(VerifyResult.verify(result, expectedResult));
    }

    @Test
    public void addTest2(){
        Polynomial p1 = new Polynomial();
        p1.getPolinom().add(new Monomial(2, 4));
        p1.getPolinom().add(new Monomial(-4, 3));
        p1.getPolinom().add(new Monomial(1, 2));
        p1.getPolinom().add(new Monomial(-2, 0));
        Polynomial p2 = new Polynomial();
        p2.getPolinom().add(new Monomial(1, 5));
        p2.getPolinom().add(new Monomial(-1, 3));
        p2.getPolinom().add(new Monomial(2, 1));
        p2.getPolinom().add(new Monomial(3, 0));

        Polynomial result = p1.add(p2);

        Polynomial expectedResult = new Polynomial();
        expectedResult.getPolinom().add(new Monomial(1, 5));
        expectedResult.getPolinom().add(new Monomial(2, 4));
        expectedResult.getPolinom().add(new Monomial(-5, 3));
        expectedResult.getPolinom().add(new Monomial(1, 2));
        expectedResult.getPolinom().add(new Monomial(2, 1));
        expectedResult.getPolinom().add(new Monomial(1, 0));


        assertTrue(VerifyResult.verify(result, expectedResult));
    }
}
