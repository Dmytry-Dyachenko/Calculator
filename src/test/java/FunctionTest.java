import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionTest {
    final CalculatorImpl calculator = new CalculatorImpl();
    @Test
    public void testSumFunction() throws CalculationException {
        final double result = calculator.calculate("sum((1+2),2^3,3)");
        assertEquals(14,result,0.001);
    }
}
