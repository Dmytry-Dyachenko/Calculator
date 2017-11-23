package javaclasses.calculator.impl.operator;
/**
 * Implementation the power.
 */
public class ExponentiationOperator extends AbstractBinaryOperator {

    public ExponentiationOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }
}
