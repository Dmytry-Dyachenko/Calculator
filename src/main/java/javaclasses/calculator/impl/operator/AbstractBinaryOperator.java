package javaclasses.calculator.impl.operator;

import javaclasses.calculator.impl.BinaryOperator;

public abstract class AbstractBinaryOperator implements BinaryOperator<AbstractBinaryOperator> {

    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private final Priority priority;

    public AbstractBinaryOperator(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(AbstractBinaryOperator o) {
        return this.priority.ordinal() > o.priority.ordinal() ? 1 : 0;
    }
}
