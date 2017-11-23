package javaclasses.calculator.impl.operator;

/**
 * Implementation the multiple.
 */
public class MultiplicationOperator extends AbstractBinaryOperator {

    MultiplicationOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double evaluate(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }
}
