package javaclasses.calculator.impl.operator;

/**
 * Implementation the division.
 */

public class DivisionOperator extends AbstractBinaryOperator {

    DivisionOperator(Priority priority) {
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
