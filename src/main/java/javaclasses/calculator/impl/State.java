package javaclasses.calculator.impl;

public enum State {
    START,
    NUMBER,
    BINARY_OPERATOR,
    OPEN_BRACKET,
    CLOSE_BRACKET,
    FUNCTION,
    FINISH
}
