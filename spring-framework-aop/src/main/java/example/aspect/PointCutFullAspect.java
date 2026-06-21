package example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutFullAspect {

    @Pointcut("execution(* example.component.PointCutClass.*(..))")
    private void pointCut() {
    }

    // 前置通知
    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        Object objectOriginal = joinPoint.getTarget();  // 拿到被代理的原始对象
        // objectOriginal..method(); 直接调用到原始对象的方法

        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
    }

    // 异常通知在catch中执行
    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing() {
        System.out.println("methodAfterThrowing");
    }

    // TODO. afterReturning在方法最后触发, 不一定能执行到
    // AfterReturningAdviceInterceptor.invoke方法
    // public Object invoke(MethodInvocation mi) throws Throwable {
    //    Object retVal = mi.proceed();
    //    this.advice.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
    //    return retVal;
    // }
    @AfterReturning(value = "pointCut()", returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        System.out.println("methodReturning");
    }

    // TODO: 后置通知的方法始终会被执行: AspectJAfterAdvice.invoke方法
    // public Object invoke(MethodInvocation mi) throws Throwable {
    //   try {
    //		 return mi.proceed();
    //	  } finally {
    //		 invokeAdviceMethod(getJoinPointMatch(), null, null);
    //	  }
    // }
    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println("MethodAfter");
    }
}