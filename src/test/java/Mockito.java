
import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.ErrorHandler;
import javaclasses.calculator.impl.BinaryOperator;
import javaclasses.calculator.impl.CalculatorImpl;
import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionReader;
import javaclasses.calculator.impl.parser.BinaryOperatorParser;
import javaclasses.calculator.impl.parser.FunctionParser;
import javaclasses.calculator.impl.parser.NumberParser;
import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class Mockito {
    final private EvaluationContext context = new EvaluationContext(new ErrorHandler() {
        @Override
        public void raiseError(String message) throws CalculationException {

        }
    });

    @Test
    public void testNumberParser() throws CalculationException {
        final ExpressionReader reader = new ExpressionReader("1");
        NumberParser test = mock(NumberParser.class);
        when(test.parse(reader, context)).thenReturn(true);
    }

    @Test
    public void testBinaryParser() throws CalculationException {
        final ExpressionReader reader = new ExpressionReader("/");
        BinaryOperatorParser test = mock(BinaryOperatorParser.class);
        when(test.parse(reader, context)).thenReturn(true);
    }

    @Test
    public void testPlusBinaryOperator() throws CalculationException {
        final ExpressionReader reader = new ExpressionReader("+");
        BinaryOperatorParser test = mock(BinaryOperatorParser.class);
        when(test.parse(reader, context)).thenReturn(true);
    }


}