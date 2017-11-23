package javaclasses.calculator.impl;


import javaclasses.calculator.impl.function.FunctionFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * There place will be used for name and arguments holding.
 */

class FunctionEvaluationContext {

    private Deque<String> functionsName = new ArrayDeque<>();
    private Deque<List<Double>> functionArguments = new ArrayDeque<>();
    private Deque<Integer> functionPositions = new ArrayDeque<>();

    FunctionEvaluationContext(String functionName, int functionPosition) {
        this.functionsName.push(functionName);
        this.functionArguments.push(new ArrayList<>());
        //todo: find another way to say to function, that we create another stack especially for it.
        this.functionPositions.push(functionPosition + 1);
    }

    Deque<List<Double>> getFunctionArguments() {
        return functionArguments;
    }

    Deque<Integer> getFunctionPositions() {
        return functionPositions;
    }

    double executeFunction() {
        final FunctionFactory factory = new FunctionFactory();
        return factory.getFunction(functionsName.pop()).execute(functionArguments.pop());
    }
}
