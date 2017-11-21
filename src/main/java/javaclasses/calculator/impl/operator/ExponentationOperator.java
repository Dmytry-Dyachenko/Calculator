package javaclasses.calculator.impl.operator;

public class ExponentationOperator extends AbstractBinaryOperator {

    public ExponentationOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
