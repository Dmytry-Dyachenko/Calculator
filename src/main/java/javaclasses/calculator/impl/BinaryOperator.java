package javaclasses.calculator.impl;

public interface BinaryOperator<Op extends BinaryOperator> extends Comparable<Op> {

    double evaluate(double leftOperand, double rightOperand);
}
