package javaclasses.calculator.impl;


import javaclasses.calculator.impl.function.FunctionFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class FunctionEvaluationContext {
    private Deque<String> functionsName = new ArrayDeque<>();
    private Deque<List<Double>> functionArguments = new ArrayDeque<>();
    private Deque<Integer> functionPositions = new ArrayDeque<>();

    FunctionEvaluationContext(String functionName, int functionPosition){
        this.functionsName.push(functionName);
        this.functionArguments.push(new ArrayList<>());
        this.functionPositions.push(functionPosition);
    }

    public Deque<List<Double>> getFunctionArguments() {
        return functionArguments;
    }

    public Deque<Integer> getFunctionPositions() {
        return functionPositions;
    }

    public double executeFunction() {
        final FunctionFactory factory = new FunctionFactory();
        return factory.getFunction(functionsName.pop()).execute(functionArguments.pop());
    }
}
