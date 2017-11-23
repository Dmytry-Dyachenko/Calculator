package javaclasses.calculator.impl.function;


import javaclasses.calculator.impl.CalculatorImpl;
import javaclasses.calculator.impl.Function;

import java.util.Deque;
import java.util.List;

/**
 * Implementation of the sum function.
 */

public class SumFunction implements Function {
    @Override
    public double execute(List<Double> arguments) {
        CalculatorImpl calculator = new CalculatorImpl();
        double sum = 0;
        for (double argument : arguments
                ) {
            sum += argument;
        }
        return sum;
    }
}
