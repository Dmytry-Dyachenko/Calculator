package javaclasses.calculator.impl.parser;

import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;

/**
 * Checking for "delimiter" state.
 */
public class DelimiterParser implements ExpressionParser {

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) throws CalculationException {
        final String DELIMITER = ",";
        final String expression = reader.getRemainingExpression();
        if (expression.startsWith(DELIMITER)) {
            context.pushDelimiter();
            reader.incrementParsePosition(DELIMITER.length());
            return true;
        }
        return false;
    }
}

