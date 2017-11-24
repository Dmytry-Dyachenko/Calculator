package javaclasses.calculator.impl.function;

import javaclasses.calculator.impl.Function;

import java.util.List;

/**
 * Implementation of the min function.
 */

public class DefaultFunction implements Function {
    @Override
    public double execute(List<Double> arguments) {
        return arguments.get(0);
    }

    @Override
    public int getMinCountOfArguments() {
        return 1;
    }

    @Override
    public int getMaxCountOfArguments() {
        return 1;
    }
}
