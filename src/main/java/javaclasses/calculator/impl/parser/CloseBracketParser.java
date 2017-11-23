package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;

/**
 * Checking for "closeBracket" state.
 */
public class CloseBracketParser implements ExpressionParser {

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {
        final String CLOSE_BRACKET = ")";
        final String expression = reader.getRemainingExpression();
        if (expression.startsWith(CLOSE_BRACKET)) {
                context.pushClosingBracket();
            reader.incrementParsePosition(CLOSE_BRACKET.length());
            return true;
        }
        return false;
    }
}
