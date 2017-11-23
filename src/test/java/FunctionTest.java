import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionTest {
    final CalculatorImpl calculator = new CalculatorImpl();
    @Test
    public void testSumFunction() throws CalculationException {
        final double result = calculator.calculate("sum(sum((1+2),2^3,3),2)");
        assertEquals(16,result,0.001);
    }

    @Test
    public void testMinFunction() throws CalculationException {
        final double result = calculator.calculate("min(sum((1+2),2^3,3),2)");
        assertEquals(2,result,0.001);
    }
}
