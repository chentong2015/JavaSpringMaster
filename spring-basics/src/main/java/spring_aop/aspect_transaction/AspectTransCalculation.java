package spring_aop.aspect_transaction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// 针对于事务方法的切面
@Aspect
public class AspectTransCalculation {

    @Pointcut("execution(* spring_aop.aspect_transaction.TransactionCalculation.pay())")
    private void pointCut() {
    }

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before the method called: " + methodName);
    }
}
