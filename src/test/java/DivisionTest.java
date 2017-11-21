import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisionTest {
    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testSingleDivisionOperator() throws CalculationException {
        final double result = calculator.calculate("27/9");
        assertEquals(3.0, result, 0.001);
    }

    @Test
    public void testMultiDivisionOperatorWithIntegers() throws CalculationException {
        final double result = calculator.calculate("27/9/3");
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testMultiDivisionOperator() throws CalculationException {
        final double result = calculator.calculate("21.6/3/2");
        assertEquals(3.6, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testNullDivision() throws CalculationException {
        calculator.calculate("1/0");
    }

}
