package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectRaceService {

    @Pointcut("execution(* com.example.aop.aspect.MyServiceClass.printSomething(..))")
    private void pointCutPrinting() {
    }

    @After(value = "pointCutPrinting()")
    public void publishPrintMessage(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        // To do something with args
    }

    // Publish message to MQ bus
    private void publishMessage(String name) {
        String message = "New '" + name + "' has been created and stored in DB";
        System.out.println(message);
    }
}
