package javaclasses.calculator.impl;


import javaclasses.calculator.CalculationException;
import javaclasses.calculator.ErrorHandler;
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

    private final FunctionFactory factory = new FunctionFactory();


    FunctionEvaluationContext(String functionName, int functionPosition) {
        this.functionsName.push(functionName);
        this.functionArguments.push(new ArrayList<>());
        this.functionPositions.push(functionPosition + 1);
    }

    Deque<List<Double>> getFunctionArguments() {
        return functionArguments;
    }

    Deque<Integer> getFunctionPositions() {
        return functionPositions;
    }

    double executeFunction(ErrorHandler handler) throws CalculationException {
        isPossibleQuantityOfArguments(handler);
        return factory.getFunction(functionsName.pop()).execute(functionArguments.pop());
    }

    private void isPossibleQuantityOfArguments(ErrorHandler handler) throws CalculationException {
        int minCount = factory.getFunction(functionsName.peek()).getMinCountOfArguments();
        int maxCount = factory.getFunction(functionsName.peek()).getMaxCountOfArguments();
        int currentCount = functionArguments.peek().size();
        if (currentCount < minCount || currentCount > maxCount) {
            handler.raiseError("Illegal quantity of function arguments ");
        }
    }
}
