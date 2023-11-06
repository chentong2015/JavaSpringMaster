package com.aspectj.template.aspect;

import com.aspectj.template.TracedClass;
import com.aspectj.template.model.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

class TracingAspectTest {

    private TracedClass tracedClass; // 被代理类(被拦截的类型)
    private TracedClass tracedClassProxy; // Proxy代理类(实际调用的Proxy Method)

    @BeforeEach
    void setup() {
        tracedClass = new TracedClass();

        // 静态测试, 自定义构建Proxy Class, 测试代理方法的执行
        AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(tracedClass);
        aspectJProxyFactory.addAspect(TracingAspect.class);
        tracedClassProxy = aspectJProxyFactory.getProxy();
    }

    @Test
    void should_trace_method_with_dynamic_operation_name() {
        String operation = "myOperation";
        tracedClassProxy.tracedMethod(operation);
    }

    @Test
    void should_trace_method_with_return_value() {
        String label1 = "myLabel1";
        int srcCorrelationId = tracedClassProxy.tracedMethodWithReturnValue(label1, "myLabel2");
        System.out.println(srcCorrelationId);
    }

    @Test
    void should_trace_method_with_default_property_extractor() {
        int commandId = 8721;
        String commandName = "myCommand";
        tracedClassProxy.tracedMethodWithDefaultExtractor(new Command(commandId, commandName));
    }
}
