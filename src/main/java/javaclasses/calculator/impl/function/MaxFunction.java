package javaclasses.calculator.impl.function;

import javaclasses.calculator.impl.Function;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of the max function.
 */

public class MaxFunction implements Function {
    @Override
    public double execute(List<Double> arguments) {
        return Collections.max(arguments);
    }
}
