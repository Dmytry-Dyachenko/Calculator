package javaclasses.calculator.impl.function;

import javaclasses.calculator.impl.ExpressionParser;
import javaclasses.calculator.impl.Function;
import javaclasses.calculator.impl.State;
import javaclasses.calculator.impl.parser.*;

import java.util.HashMap;
import java.util.Map;

import static javaclasses.calculator.impl.State.*;

public class FunctionFactory {

    private final Map<String, Function> functions = new HashMap<String, Function>() {{
        put("sum", new SumFunction());
    }};

    public Function getFunction(String name) {

        if (!functions.containsKey(name)) {
            throw new IllegalStateException("Function with name :" + name + " not found.");
        }

        return functions.get(name);
    }
}
