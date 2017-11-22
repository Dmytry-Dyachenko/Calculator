package javaclasses.calculator.impl.parser;

import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.State;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.calculator.impl.State.*;

public class ParserFactory {

    private final Map<State, ExpressionParser> parsers = new HashMap<State, ExpressionParser>() {{
        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());
        put(OPEN_BRACKET, new OpenBracketParser());
        put(CLOSE_BRACKET, new CloseBracketParser());
        put(FUNCTION, new FunctionParser());
        put(FINISH, new EndOfExpressionParser());
    }};

    public ExpressionParser getParser(State state) {

        if (!parsers.containsKey(state)) {
            throw new IllegalStateException("Parser not found for state: " + state);
        }

        return parsers.get(state);
    }
}
