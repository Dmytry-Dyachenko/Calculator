package javaclasses.calculator.impl.function;

import javaclasses.calculator.impl.Function;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of the min function.
 */

public class MinFunction implements Function {
    @Override
    public double execute(List<Double> arguments) {
        return Collections.min(arguments);
    }
}
