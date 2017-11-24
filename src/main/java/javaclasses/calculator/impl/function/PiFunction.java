package javaclasses.calculator.impl.function;

import javaclasses.calculator.impl.Function;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of the min function.
 */

public class PiFunction implements Function {
    @Override
    public double execute(List<Double> arguments) {
        return Math.PI;
    }

    @Override
    public int getMinCountOfArguments() {
        return 0;
    }

    @Override
    public int getMaxCountOfArguments() {
        return 0;
    }
}
