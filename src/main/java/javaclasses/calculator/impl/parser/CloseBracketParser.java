package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;

public class CloseBracketParser implements ExpressionParser {

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {
        final String expression = reader.getRemainingExpression();
        if (expression.startsWith(")")) {
            context.pushClosingBracket();
            reader.incrementParsePosition(1);
            return true;
        }
        return false;
    }
}
