package javaclasses.calculator;

/**
 * xception with information about
 * location of error in expression string.
 */
public class CalculationException extends Exception {

    private final int errorPosition;

    public CalculationException(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }


    public int getErrorPosition() {
        return errorPosition;
    }
}
