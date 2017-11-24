package javaclasses.calculator.impl;

import javaclasses.calculator.CalculationException;
import javaclasses.calculator.ErrorHandler;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The storage for all expressions and their results.
 */
public class EvaluationContext {

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<Deque<BinaryOperator>> operatorStack = new ArrayDeque<>();
    private final Deque<FunctionEvaluationContext> functions = new ArrayDeque<>();

    private ErrorHandler handler;

    public EvaluationContext(ErrorHandler handler) {
        this.operatorStack.push(new ArrayDeque<>());
        this.handler = handler;
    }

    /**
     * Push the number to operands stack.
     *
     * @param value is a number.
     */
    public void pushNumber(double value) {
        operandStack.push(value);
    }

    /**
     * @return the result of all calculating.
     */
    public double getResult() throws CalculationException {

        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
        return operandStack.pop();
    }

    /**
     * Make a calculating between stacks of operators and operands.
     */
    private void popTopOperator() throws CalculationException {

        final BinaryOperator operator = operatorStack.peek().pop();
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();
        final double result = operator.evaluate(leftOperand, rightOperand);
        operandStack.push(result);
    }

    /**
     * Push the binary operator to the stack of operators.
     */
    public void pushBinaryOperator(BinaryOperator operator) throws CalculationException {
        while (!operatorStack.peek().isEmpty() && operator.compareTo(operatorStack.peek().peek()) < 1) {
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
    public void pushClosingBracket() throws CalculationException {
        calculateTopExpression();
        if (functions.isEmpty() || functions.peek().getFunctionPositions().peek() < operatorStack.size()) {
            operatorStack.pop();
        } else {
            pushDelimiter(); // Function closing bracket it is the last delimiter.
            final double funcExecutingResult = functions.pop().executeFunction(handler);
            operandStack.push(funcExecutingResult);
            operatorStack.pop();
        }
    }

    public void pushFunctionToContext(String functionName) {
        functions.push(new FunctionEvaluationContext(functionName, operatorStack.size()));
    }

    public void pushDelimiter() throws CalculationException {
        calculateTopExpression();
        final double functionArgument = operandStack.pop();
        functions.peek().getFunctionArguments().peek().add(functionArgument);
    }

    private void calculateTopExpression() throws CalculationException {
        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
    }
}
