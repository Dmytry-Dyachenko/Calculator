import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlusTest {
    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testSinglePlusOperator() throws CalculationException {
        final double result = calculator.calculate("1+11");
        assertEquals(12.0, result, 0.001);
    }

    @Test
    public void testMultiPlusOperatorWithIntegers() throws CalculationException {
        final double result = calculator.calculate("1+2+11+22");
        assertEquals(36.0, result, 0.001);
    }

    @Test
    public void testMultiPlusOperator() throws CalculationException {
        final double result = calculator.calculate("1+2.4+1.22+2.02");
        assertEquals(6.64, result, 0.001);
    }

}
