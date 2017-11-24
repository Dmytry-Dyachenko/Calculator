import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionTest {
    final CalculatorImpl calculator = new CalculatorImpl();

    @Test
    public void testSumFunction() throws CalculationException {
        final double result = calculator.calculate("sum(2,8,4,2)");
        assertEquals(16, result, 0.001);
    }

    @Test
    public void testMinFunction() throws CalculationException {
        final double result = calculator.calculate("min(5,11,13,15,2)");
        assertEquals(2, result, 0.001);
    }
    @Test
    public void testMaxFunction() throws CalculationException {
        final double result = calculator.calculate("max(5,2,8,3,7,6)");
        assertEquals(8, result, 0.001);
    }

    @Test
    public void testAverageFunction() throws CalculationException {
        final double result = calculator.calculate("aver(5,2,8)");
        assertEquals(5, result, 0.001);
    }

    @Test
    public void testEmbeddedFunctions() throws CalculationException {
        final double result = calculator.calculate("min(aver(sum(11,1,1),2),10)");
        assertEquals(7.5, result, 0.001);
    }

    @Test
    public void testPiFunction() throws CalculationException {
        final double result = calculator.calculate("1+2*3+pi()");
        assertEquals(7+Math.PI, result, 0.001);
    }
}
