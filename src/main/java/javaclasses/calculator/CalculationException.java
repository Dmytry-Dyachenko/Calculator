package javaclasses.calculator;

/**
 * xception with information about
 * location of error in expression string.
 */
public class CalculationException extends Exception {

    public CalculationException(String message) {
        super(message);
    }

}
