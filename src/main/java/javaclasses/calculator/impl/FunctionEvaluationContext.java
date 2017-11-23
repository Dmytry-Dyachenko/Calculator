package javaclasses.calculator.impl;


import java.util.ArrayDeque;
import java.util.Deque;

public class FunctionEvaluationContext {
    private Deque<String> functionsName = new ArrayDeque<>();
    private Deque<Deque<Double>> functionArguments = new ArrayDeque<>();

    FunctionEvaluationContext(String functionName){
        this.functionsName.push(functionName);
        this.functionArguments.push(new ArrayDeque<>());
    }

    public Deque<String> getFunctionsName() {
        return functionsName;
    }

    public Deque<Deque<Double>> getFunctionArguments() {
        return functionArguments;
    }

    public void setFunctionArguments(Deque<Deque<Double>> functionArguments) {
        this.functionArguments = functionArguments;
    }
}
