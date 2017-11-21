package javaclasses.calculator.impl;

public class ExpressionReader {

    private final String expression;
    private int parsePosition = 0;

    public ExpressionReader(String expression) {
        this.expression = expression;
    }

    public boolean endOfExpression() {
        return parsePosition >= expression.length();
    }

    public int getParsePosition() {
        return parsePosition;
    }

    public void incrementParsePosition(int value) {
        parsePosition += value;
    }

    public String getRemainingExpression() {
        return expression.substring(parsePosition);
    }
}
