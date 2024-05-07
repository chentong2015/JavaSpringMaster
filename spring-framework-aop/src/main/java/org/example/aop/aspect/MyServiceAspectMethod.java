package org.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyServiceAspectMethod {

    // 只针对某个方法进行拦截
    @Pointcut("execution(* org.example.aop.bean.ServiceClass.printSomething(..))")
    private void pointCutPrinting() {
    }

    @After(value = "pointCutPrinting()")
    public void publishPrintMessage(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("after pointcut printing");
    }
}
