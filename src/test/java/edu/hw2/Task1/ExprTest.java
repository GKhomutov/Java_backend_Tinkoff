package edu.hw2.Task1;

import edu.hw2.Task1.Expr.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExprTest {
    @Test
    void exprMegaTest() {
        final double epsilon = 1e-7;

        var two = new Constant(2);
        var four = new Constant(4);
        assertEquals(two.evaluate(), 2, epsilon);
        assertEquals(four.evaluate(), 4, epsilon);

        var negOne = new Negate(new Constant(1));
        assertEquals(negOne.evaluate(), -1, epsilon);

        var sumTwoFour = new Addition(two, four);
        assertEquals(sumTwoFour.evaluate(), 6, epsilon);

        var mult = new Multiplication(sumTwoFour, negOne);
        assertEquals(mult.evaluate(), -6, epsilon);

        var pow = new Exponent(mult, 2);
        assertEquals(pow.evaluate(), 36, epsilon);

        var res = new Addition(pow, new Constant(1));
        assertEquals(res.evaluate(), 37, epsilon);
    }
}
