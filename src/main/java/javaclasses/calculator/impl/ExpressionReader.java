package javaclasses.calculator.impl;

/**
 * Information and work with string of input math expression.
 */
public class ExpressionReader {

    private final String expression;
    private int parsePosition = 0;

    public ExpressionReader(String expression) {
        this.expression = expression;
    }

    /**
     * Check our current position and
     *
     * @return true if we reached the end.
     */
    public boolean endOfExpression() {
        return parsePosition >= expression.length();
    }

    public int getParsePosition() {
        return parsePosition;
    }

    public void incrementParsePosition(int value) {
        parsePosition += value;
    }

    /**
     * @return the current expression, taking into account the passed operations.
     */
    public String getRemainingExpression() {
        return expression.substring(parsePosition);
    }
}
