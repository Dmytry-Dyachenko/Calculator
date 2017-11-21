package javaclasses.calculator.impl.operator;

import javaclasses.calculator.CalculationException;

public class DivisionOperator extends AbstractBinaryOperator {

    public DivisionOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        if (rightOperand == 0) {
            throw new ArithmeticException("Division on null");
        }
        return leftOperand / rightOperand;
    }
}
