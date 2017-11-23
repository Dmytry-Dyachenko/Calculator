package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;

/**
 * Checking for "openBracket" state.
 */
public class OpenBracketParser implements ExpressionParser {

    private final String OPEN_BRACKET = "(";

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {
        final String expression = reader.getRemainingExpression();
        if (expression.startsWith(OPEN_BRACKET)) {
            context.pushOpeningBracket();
            reader.incrementParsePosition(OPEN_BRACKET.length());
            return true;
        }
        return false;
    }
}
