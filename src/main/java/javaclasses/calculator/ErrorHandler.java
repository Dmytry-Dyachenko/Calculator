package javaclasses.calculator;

public interface ErrorHandler  {
    default void raiseError(String message) throws CalculationException{
    }
}
