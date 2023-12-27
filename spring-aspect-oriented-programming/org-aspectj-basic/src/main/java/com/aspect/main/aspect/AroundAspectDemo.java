package com.aspect.main.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AroundAspectDemo {

    private static boolean runAround = true;

    public void hello() {
        System.err.println("in hello");
    }

    // execution() 定义被拦截的方法的原型
    @Around("execution(void com.aspect.main.aspect.AroundAspectDemo.hello())")
    public void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("in around before " + joinPoint);
        if (runAround) {
            // JoinPoint连接点: 指定被拦截的方法的主体逻辑
            joinPoint.proceed();
        }
        System.err.println("in around after " + joinPoint);
    }

    @Before("execution(void com.aspect.main.aspect.AroundAspectDemo.hello())")
    public void beforeHello(JoinPoint joinPoint) {
        System.err.println("before " + joinPoint);
    }

    @After("execution(void com.aspect.main.aspect.AroundAspectDemo.hello())")
    public void afterHello(JoinPoint joinPoint) {
        System.err.println("after " + joinPoint);
    }

    // @Around定义被拦截的方法所执行的前后文:
    // in around before execution(void xxx.hello())
    //   before execution(void xxx.hello())
    //     in hello
    //   after execution(void xxx.hello())
    // in around after execution(void xxx.hello())
    // in around before execution(void xxx.hello())
    // in around after execution(void xxx.hello())
    public static void main(String[] args) {
        new AroundAspectDemo().hello();
        runAround = false;
        new AroundAspectDemo().hello();
    }
}
