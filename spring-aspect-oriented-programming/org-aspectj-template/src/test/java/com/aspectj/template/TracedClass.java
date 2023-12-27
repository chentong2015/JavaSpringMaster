package com.aspectj.template;

import com.aspectj.template.aspect.Traced;
import com.aspectj.template.aspect.TracedProperty;
import com.aspectj.template.model.Command;

public class TracedClass {

    @TracedProperty
    private final String context = "class context";

    @Traced(operation = "staticOperationName")
    public void tracedMethod(@TracedProperty String operation) {
        System.out.println("call traced method");
    }

    // @Traced(operation = "staticOperationName")
    public int tracedMethodWithReturnValue(@TracedProperty String input1, String input2) {
        return 5431;
    }

    @Traced(operation = "staticOperationName")
    public void tracedMethodWithDefaultExtractor(@TracedProperty Command command) {
        System.out.println("call tracedMethodWithDefaultExtractor");
    }
}
