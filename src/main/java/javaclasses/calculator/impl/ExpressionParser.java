package javaclasses.calculator.impl;

public interface ExpressionParser {

    boolean parse(ExpressionReader reader, EvaluationContext context);
}
