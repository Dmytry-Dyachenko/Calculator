package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;

public class OpenBracketParser implements ExpressionParser {

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {
        final String expression = reader.getRemainingExpression();
        if (expression.startsWith("(")) {
            context.pushOpeningBracket();
            reader.incrementParsePosition(1);
            return true;
        }
        return false;
    }
}
