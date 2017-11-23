package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.EvaluationContext;
import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.ExpressionReader;
import javaclasses.calculator.impl.function.FunctionFactory;


/**
 * Checking for "function" state.
 */

public class FunctionParser implements ExpressionParser {

    private final FunctionFactory factory = new FunctionFactory();

    @Override
    public boolean parse(ExpressionReader reader, EvaluationContext context) {

        final String expression = reader.getRemainingExpression();

        for (String name : factory.getFunctionsName()) {
            if (expression.startsWith(name)) {
                context.pushFunctionToContext(name);
                reader.incrementParsePosition(name.length());
                return true;
            }
        }
        return false;
    }

}
