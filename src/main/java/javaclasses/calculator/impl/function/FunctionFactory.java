package javaclasses.calculator.impl.function;


import javaclasses.calculator.impl.Function;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Router connecting function and their executing.
 */


public class FunctionFactory {

    private final Map<String, Function> functions = new HashMap<String, Function>() {{
        put("sum", new SumFunction());
        put("min", new MinFunction());
        put("max", new MaxFunction());
        put("aver", new AverageFunction());
        put("pi", new PiFunction());
        put("default", new DefaultFunction());
    }};

    public Function getFunction(String name) {

        if (!functions.containsKey(name)) {
            throw new IllegalStateException("Function with name :" + name + " not found.");
        }

        return functions.get(name);
    }

    public Set<String> getFunctionsName() {
        return functions.keySet();
    }
}
