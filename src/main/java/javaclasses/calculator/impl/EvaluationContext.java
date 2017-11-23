package javaclasses.calculator.impl;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The storage for all expressions and their results.
 */
public class EvaluationContext {

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<Deque<BinaryOperator>> operatorStack = new ArrayDeque<>();
    private final Deque<FunctionEvaluationContext> functions = new ArrayDeque<>();

    public EvaluationContext() {
        this.operatorStack.push(new ArrayDeque<>());
    }

    /**
     * Push the number to operands stack.
     *
     * @param value
     */
    public void pushNumber(double value) {
        operandStack.push(value);
    }

    /**
     *
     * @return the result of all calculating.
     */
    public double getResult() {

        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
        return operandStack.pop();
    }

    public void putFunctionToContext(String functionName){
        functions.push(new FunctionEvaluationContext(functionName));
    }

    /**
     * Make a calculating between stacks of operators and operands.
     */
    private void popTopOperator() {

        final BinaryOperator operator = operatorStack.peek().pop();
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final double result = operator.evaluate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    /**
     * Push the binary operator to the stack of operators.
     * @param operator
     */
    public void pushBinaryOperator(BinaryOperator operator) {
        while (!operatorStack.peek().isEmpty() && operator.compareTo(operatorStack.peek().peek()) != 1) {
            popTopOperator();
        }
        operatorStack.peek().push(operator);
    }

    /**
     * Create a new stack for expressions inside the brackets.
     */
    public void pushOpeningBracket() {
        operatorStack.push(new ArrayDeque<>());
    }

    /**
     * Calculating all expressions inside the brackets if it is the end.
     */
    public void pushClosingBracket() {
        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
        operatorStack.pop();
    }
}
