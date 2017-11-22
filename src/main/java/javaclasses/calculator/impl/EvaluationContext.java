package javaclasses.calculator.impl;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationContext {

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<Deque<BinaryOperator>> operatorStack = new ArrayDeque<>();

    public EvaluationContext(){
        this.operatorStack.push(new ArrayDeque<>());
    }

    public void pushNumber(double value) {
        operandStack.push(value);
    }

    public double getResult() {

        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
        return operandStack.pop();
    }

    private void popTopOperator() {

        final BinaryOperator operator = operatorStack.peek().pop();
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final double result = operator.evaluate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    public void pushBinaryOperator(BinaryOperator operator) {
        while (!operatorStack.peek().isEmpty() && operator.compareTo(operatorStack.peek().peek()) != 1){
            popTopOperator();
        }
        operatorStack.peek().push(operator);
    }

    public void pushOpeningBracket() {
        operatorStack.push(new ArrayDeque<>());
    }

    public void pushClosingBracket() {
        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
        operatorStack.pop();
    }
}
