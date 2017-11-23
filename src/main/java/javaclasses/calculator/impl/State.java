package javaclasses.calculator.impl;

/**
 * The all possible states of our machine.
 */
public enum State {
    START,
    NUMBER,
    BINARY_OPERATOR,
    OPEN_BRACKET,
    CLOSE_BRACKET,
    DELIMETER,
    FUNCTION,
    FINISH
}
