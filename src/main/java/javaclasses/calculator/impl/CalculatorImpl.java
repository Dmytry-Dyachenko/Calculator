package javaclasses.calculator.impl;

import javaclasses.calculator.CalculationException;
import javaclasses.calculator.Calculator;
import javaclasses.calculator.fsm.FiniteStateMachine;
import javaclasses.calculator.impl.parser.ParserFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.EnumSet.of;
import static javaclasses.calculator.impl.State.*;

public class CalculatorImpl
        extends FiniteStateMachine<
        ExpressionReader,
        EvaluationContext,
        State,
        CalculationException>
        implements Calculator {

    private final ParserFactory parserFactory = new ParserFactory();

    private final Map<State, Set<State>> transitions = new HashMap<State, Set<State>>() {{
        put(START, of(NUMBER, OPEN_BRACKET));
        put(NUMBER, of(BINARY_OPERATOR, CLOSE_BRACKET, FINISH));
        put(BINARY_OPERATOR, of(NUMBER, OPEN_BRACKET));
        put(OPEN_BRACKET, of(NUMBER, OPEN_BRACKET));
        put(CLOSE_BRACKET, of(CLOSE_BRACKET, BINARY_OPERATOR, FINISH));
    }};

    @Override
    public double calculate(String expression) throws CalculationException {
        final EvaluationContext evaluationContext = new EvaluationContext();
        start(START, new ExpressionReader(expression), evaluationContext);
        return evaluationContext.getResult();
    }

    @Override
    protected boolean acceptState(ExpressionReader reader,
                                  EvaluationContext context, State nextState) {

        final ExpressionParser parser = parserFactory.getParser(nextState);
        return parser.parse(reader, context);
    }

    @Override
    protected boolean isFinishState(State state) {
        return state == FINISH;
    }

    @Override
    protected Set<State> getPossibleTransitions(State state) {
        return transitions.get(state);
    }

    @Override
    protected void raiseDeadlockError(State state, ExpressionReader reader)
            throws CalculationException {

        throw new CalculationException("Incorrect expression format.",
                reader.getParsePosition());

    }
}