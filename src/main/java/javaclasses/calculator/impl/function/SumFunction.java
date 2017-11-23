package javaclasses.calculator.impl.function;


import javaclasses.calculator.impl.Function;

import java.util.List;

/**
 * Implementation of the sum function.
 */

public class SumFunction implements Function {
    @Override
    public double execute(List<Double> arguments) {
        double sum = 0;
        for (double argument : arguments
                ) {
            sum += argument;
        }
        return sum;
    }
}
