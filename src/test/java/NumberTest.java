
import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NumberTest {

    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testIntValue() throws CalculationException {
        final double result = calculator.calculate("5");
        assertEquals(5.0, result, 0.00001);
    }

    @Test
    public void testFloatNumber() throws CalculationException {
        final double result = calculator.calculate("2.25");
        assertEquals(2.25, result, 0.00001);
    }

    @Test
    public void testMinusValue() throws CalculationException {
        final double result = calculator.calculate("-12");
        assertEquals(-12.0, result, 0.00001);
    }

    @Test(expected = CalculationException.class)
    public void testValidationOfExpression() throws CalculationException {
        calculator.calculate("kfj");
    }

}
