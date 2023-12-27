package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

// TODO: 默认自定义的切面和事务的切面优先级一致，和源码解析的顺序一致 / 可以设置自定义的切面优先级更高
// Order注解指定多个切面的执行顺序，数值越大优先级越低，默认Integer.MAX_VALUE
@Aspect
@Order(value = 10)
public class AspectFastCalculation {

    // 切入点：调用指定类型中的所有方法
    @Pointcut("execution(* com.example.aop.aspect.MyServiceClass.*(..))")
    private void pointCut() {
    }

    // 1. 前置通知
    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        joinPoint.getTarget();  // TODO: 拿到被代理的原始对象
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
    }

    // 2. Call Method 方法的真正调用
    // JoinPoint.getTarget().method();

    // 3. 返回通知: 正常return
    //   AfterReturningAdviceInterceptor类型
    //   public Object invoke(MethodInvocation mi) throws Throwable {
    //	   TODO：如果在这里抛出异常，往上抛出，则后面的afterReturning返回通知不会被执行到
    //          mi.proceed()该方法往内层调用，如果目标方法抛出异常，则往上跑，不会执行后面的语句
    //	   Object retVal = mi.proceed();
    //	   this.advice.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
    //	   return retVal;
    //	 }
    @AfterReturning(value = "pointCut()", returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        System.out.println("methodReturning");
    }

    // 4. 异常通知 ==> catch中执行
    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing() {
        System.out.println("methodAfterThrowing");
    }

    // 5. 后置通知 ==> finally中执行
    //    AspectJAfterAdvice类型，invoke方法
    //    public Object invoke(MethodInvocation mi) throws Throwable {
    //		 try {
    //			return mi.proceed();
    //		 } finally {
    //          TODO: 后置通知的方法始终会被执行
    //			invokeAdviceMethod(getJoinPointMatch(), null, null);
    //		 }
    //	  }
    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println("MethodAfter");
    }
}
