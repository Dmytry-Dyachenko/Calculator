import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExponentiationTest {
    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testSingleExponentiationOperator() throws CalculationException {
        final double result = calculator.calculate("2^5");
        assertEquals(32.0, result, 0.001);
    }

    @Test
    public void testMultiExponentiationOperatorWithIntegers() throws CalculationException {
        final double result = calculator.calculate("2^3^2");
        assertEquals(64.0, result, 0.001);
    }

    @Test
    public void testMultiExponentiationOperator() throws CalculationException {
        final double result = calculator.calculate("2.1^2.2^3.1");
        assertEquals(157.592516326, result, 0.001);
    }

    @Test
    public void testNullPower() throws CalculationException {
        final double result = calculator.calculate("2^0");
        assertEquals(1.0, result, 0.001);
    }
}
