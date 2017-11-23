package javaclasses.calculator;

/**
 * The main api for calculator.
 */
public interface Calculator {
    /**
     * Calculate the input expression.
     * @param expression - math expression.
     * @return The result of the calculating.
     * @throws CalculationException - exception with information about
     * location of error in expression string.
     */
    double calculate(String expression) throws CalculationException;
}
