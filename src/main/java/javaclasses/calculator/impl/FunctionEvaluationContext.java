package javaclasses.calculator.impl;


import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.function.FunctionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * There place will be used for name and arguments holding.
 */

class FunctionEvaluationContext {

    private String functionName;
    private List<Double> functionArguments = new ArrayList<>();
    private final Function function;
    private final ErrorHandler handler;

    private final FunctionFactory factory = new FunctionFactory();


    FunctionEvaluationContext(String functionName, ErrorHandler handler) {
        this.handler = handler;
        this.function = factory.getFunction(functionName);
        this.functionName = functionName;
    }

    void addArgumentToFunction(double argument) {
        functionArguments.add(argument);
    }

    double executeFunction() throws CalculationException {
        isPossibleQuantityOfArguments();
        return factory.getFunction(functionName).execute(functionArguments);
    }

    private void isPossibleQuantityOfArguments() throws CalculationException {
        int minCount = function.getMinCountOfArguments();
        int maxCount = function.getMaxCountOfArguments();

        int currentCount = functionArguments.size();

        if (currentCount < minCount) {
            handler.raiseError("Too less arguments.");
        } else if (currentCount > maxCount) {
            handler.raiseError("Too more arguments.");
        }
    }
}
