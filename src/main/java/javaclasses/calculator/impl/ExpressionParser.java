package javaclasses.calculator.impl;

import javaclasses.calculator.CalculationException;

public interface ExpressionParser {

    boolean parse(ExpressionReader reader, EvaluationContext context) throws CalculationException;
}
