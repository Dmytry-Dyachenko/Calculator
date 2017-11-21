package javaclasses.calculator.impl;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationContext {

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<>();
    private final Deque<Integer> bracketStack = new ArrayDeque<>();

    public void pushNumber(double value) {
        operandStack.push(value);
    }

    public double getResult() {

        while (!operatorStack.isEmpty()) {
            popTopOperator();
        }

        return operandStack.pop();
    }

    private void popTopOperator() {
        final BinaryOperator operator = operatorStack.pop();
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final double result = operator.evaluate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    public void pushBinaryOperator(BinaryOperator operator) {
        if (bracketStack.isEmpty()) {
            checkPriorityAndPush(operator);
        } else checkPriorityWithBrackets(operator);
    }

    public void pushOpeningBracket() {
        bracketStack.push(operatorStack.size());
    }

    public void pushClosingBracket() {
        while (operatorStack.size() > bracketStack.peek()) {
            popTopOperator();
        }
        bracketStack.pop();
    }

    private void checkPriorityAndPush(BinaryOperator operator) {
        while (!operatorStack.isEmpty() && operator.compareTo(operatorStack.peek()) != 1) {
            popTopOperator();
        }
        operatorStack.push(operator);

    }

    private void checkPriorityWithBrackets(BinaryOperator operator) {
        while (!operatorStack.isEmpty() && operator.compareTo(operatorStack.peek()) != 1 && bracketStack.peek() > operatorStack.size()) {
            popTopOperator();
        }
        operatorStack.push(operator);
    }
}
