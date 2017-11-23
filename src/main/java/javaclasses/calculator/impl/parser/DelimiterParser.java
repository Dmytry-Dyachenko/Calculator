package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;
import javaclasses.calculator.impl.operator.BinaryOperatorFactory;

/**
 * Checking for "delimiter" state.
 */
public class DelimiterParser implements ExpressionParser {

    final private String DELIMITER = ",";

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {
        final String expression = reader.getRemainingExpression();
        if (expression.startsWith(DELIMITER)) {
            context.pushOpeningBracket();
            reader.incrementParsePosition(DELIMITER.length());
            return true;
        }
        return false;
    }
}

