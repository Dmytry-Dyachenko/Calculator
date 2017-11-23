package javaclasses.calculator.impl;

public interface BinaryOperator extends Comparable<BinaryOperator> {

    double evaluate(double leftOperand, double rightOperand);
}
