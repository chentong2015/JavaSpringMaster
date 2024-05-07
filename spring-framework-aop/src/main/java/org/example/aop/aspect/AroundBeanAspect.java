package org.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// @Around定义被拦截的方法所执行的前后文
// in around before execution(void org.example.aop.bean.AroundBean.hello())
//   before execution(void org.example.aop.bean.AroundBean.hello())
//     in hello
//   after execution(void org.example.aop.bean.AroundBean.hello())
// in around after execution(void org.example.aop.bean.AroundBean.hello())
@Aspect
@Component
public class AroundBeanAspect {

    // execution() 定义被拦截的方法的原型
    @Around("execution(void org.example.aop.bean.AroundBean.hello())")
    public void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("in around before " + joinPoint);
        // JoinPoint连接点: 指定被拦截的方法的主体逻辑
        joinPoint.proceed();
        System.err.println("in around after " + joinPoint);
    }

    @Before("execution(void org.example.aop.bean.AroundBean.hello())")
    public void beforeHello(JoinPoint joinPoint) {
        System.err.println("before " + joinPoint);
    }

    @After("execution(void org.example.aop.bean.AroundBean.hello())")
    public void afterHello(JoinPoint joinPoint) {
        System.err.println("after " + joinPoint);
    }
}
