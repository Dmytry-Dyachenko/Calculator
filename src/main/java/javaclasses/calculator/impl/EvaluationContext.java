package javaclasses.calculator.impl;

import javaclasses.calculator.CalculationException;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The storage for all expressions and their results.
 */
public class EvaluationContext {

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<Deque<BinaryOperator>> operatorStack = new ArrayDeque<>();//A stack for all nesting that appear in the expression.
    private final Deque<FunctionEvaluationContext> functions = new ArrayDeque<>();//A stack with information about all functions in expression.

    private ErrorHandler handler;

    public EvaluationContext(ErrorHandler handler) {
        this.functions.push(new FunctionEvaluationContext("default", handler));
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
        if (functions.size() != operatorStack.size()) {//If the number of nesting does not correspond to the number of functions, we add the default function.
            pushFunctionToContext("default");
        }

    }

    /**
     * Calculating all expressions inside the brackets if it is the end.
     */
    public void pushClosingBracket() throws CalculationException {
        if (operatorStack.element().size() <= operandStack.size()) {
            pushDelimiter(); // Function closing bracket it is the last delimiter.
        }
        final double funcExecutingResult = functions.pop().executeFunction();
        operandStack.push(funcExecutingResult);
        operatorStack.pop();
    }

    public void pushFunctionToContext(String functionName) {
        functions.push(new FunctionEvaluationContext(functionName, handler));
    }

    public void pushDelimiter() throws CalculationException {
        popAllOperators();
        final double functionArgument = operandStack.pop();
        functions.peek().addArgumentToFunction(functionArgument);
    }

    private void popAllOperators() throws CalculationException {
        while (!operatorStack.peek().isEmpty()) {
            popTopOperator();
        }
    }
}
