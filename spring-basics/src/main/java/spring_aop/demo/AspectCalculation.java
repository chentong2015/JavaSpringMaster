package spring_aop.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

// 将相同功能的非业务代码抽象到指定类型中
// 拦截器调用的步骤:
// 1. Before the method called: add
// 2. Call add
// 3. After returning of the method
// 4. After the method called
@Aspect
public class AspectCalculation {

    // 切入点：调用指定类型中的所有方法
    @Pointcut("execution(* spring_aop.demo.FastCalculation.*(..))")
    private void pointCut() {
    }

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before the method called: " + methodName);
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println("After the method called");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After returning of the method");
    }

    // @AfterThrowing(value="pointCut()")
}
