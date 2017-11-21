import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinusTest {
    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testSingleMinusOperator() throws CalculationException {
        final double result = calculator.calculate("21-9");
        assertEquals(12.0, result, 0.001);
    }

    @Test
    public void testMultiPlusOperatorWithIntegers() throws CalculationException {
        final double result = calculator.calculate("25-11-3-10");
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testMultiPlusOperator() throws CalculationException {
        final double result = calculator.calculate("1-2.4-1.22-2.02");
        assertEquals(-4.64, result, 0.001);
    }

}
