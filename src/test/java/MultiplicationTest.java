import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.impl.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {
    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testSingleMultiplicationOperator() throws CalculationException {
        final double result = calculator.calculate("3*9");
        assertEquals(27.0, result, 0.001);
    }

    @Test
    public void testMultiMultiplicationOperatorWithIntegers() throws CalculationException {
        final double result = calculator.calculate("1*4*5");
        assertEquals(20.0, result, 0.001);
    }

    @Test
    public void testMultiMultiplicationOperator() throws CalculationException {
        final double result = calculator.calculate("1.2*1.4*12.8");
        assertEquals(21.504, result, 0.001);
    }


}
