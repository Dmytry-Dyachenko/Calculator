package javaclasses.calculator.impl.operator;

/**
 * Implementation the subtract.
 */
public class SubtractionOperator extends AbstractBinaryOperator {

    public SubtractionOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }
}
