package javaclasses.calculator.impl.operator;

import javaclasses.calculator.impl.BinaryOperator;

public abstract class AbstractBinaryOperator implements BinaryOperator {

    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private final Priority priority;

    AbstractBinaryOperator(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(BinaryOperator o) {
        return this.priority.compareTo(((AbstractBinaryOperator) o).priority);
    }
}
