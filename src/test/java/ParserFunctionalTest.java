
import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.ErrorHandler;
import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionReader;
import javaclasses.calculator.impl.parser.BinaryOperatorParser;
import javaclasses.calculator.impl.parser.NumberParser;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ParserFunctionalTest {
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