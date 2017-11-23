package javaclasses.calculator.impl.operator;
/**
 * Implementation the add.
 */
public class PlusOperator extends AbstractBinaryOperator {

    public PlusOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }
}
