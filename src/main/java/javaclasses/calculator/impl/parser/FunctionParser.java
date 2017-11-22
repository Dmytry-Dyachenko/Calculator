package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;

import java.text.ParsePosition;

public class FunctionParser implements ExpressionParser {

    final ParsePosition parsePosition = new ParsePosition(0);

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {

        return false;
    }
}
