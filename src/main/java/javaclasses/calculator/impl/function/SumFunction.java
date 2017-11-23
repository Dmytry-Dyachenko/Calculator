package javaclasses.calculator.impl.function;

import javaclasses.calculator.CalculationException;
import javaclasses.calculator.impl.CalculatorImpl;
import javaclasses.calculator.impl.Function;

/**
 * Implementation of the sum function.
 */

public class SumFunction implements Function {
    @Override
    public double execute(String[] arguments) {
        CalculatorImpl calculator = new CalculatorImpl();
        double sum = 0;
        for (String argument : arguments
                ) {
            try {
                sum += calculator.calculate(argument);
            } catch (CalculationException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }
}
