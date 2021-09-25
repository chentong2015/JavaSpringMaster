package spring_aop.aspect_base;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

// 将相同功能的非业务代码抽象到指定类型中
// 通过添加Order注解来指定多个切面的执行顺序，数值越大优先级越低，默认Integer.MAX_VALUE
// TODO: 默认自定义的切面和事务的切面优先级一致，和源码解析的顺序一致 / 可以设置自定义的切面优先级更高
@Aspect
@Order(value = 10)
public class AspectFastCalculation {

    // TODO: 拦截器advisor执行的步骤
    //

    // 切入点：调用指定类型中的所有方法
    @Pointcut("execution(* spring_aop.aspect_base.FastCalculation.*(..))")
    private void pointCut() {
    }

    // 1. 前置通知
    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
    }

    // 2. Call Method 方法的真正调用

    // 3. 返回通知
    @AfterReturning(value = "pointCut()", returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        System.out.println("methodReturning");
    }

    // 4. 后置通知
    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println("MethodAfter");
    }

    // 4. 异常通知
    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing() {
        System.out.println("methodAfterThrowing");
    }

    // TODO: 把切面的通知解析成对应的类型
    // 最终解析效果 ReflectiveAspectJAdvisorFactory.getAdvice();
    // switch (aspectJAnnotation.getAnnotationType()) {
    //	case AtAround:
    //		springAdvice = new AspectJAroundAdvice(candidateAdviceMethod, expressionPointcut, aspectInstanceFactory);
    //		break;
    //	case AtBefore:
    //		springAdvice = new AspectJMethodBeforeAdvice(candidateAdviceMethod, expressionPointcut, aspectInstanceFactory);
    //		break;
    //	case AtAfter:
    //		springAdvice = new AspectJAfterAdvice(candidateAdviceMethod, expressionPointcut, aspectInstanceFactory);
    //		break;
    //	case AtAfterReturning:
    //		springAdvice = new AspectJAfterReturningAdvice(candidateAdviceMethod, expressionPointcut, aspectInstanceFactory);
    //		AfterReturning afterReturningAnnotation = (AfterReturning) aspectJAnnotation.getAnnotation();
    //		if (StringUtils.hasText(afterReturningAnnotation.returning())) {
    //			springAdvice.setReturningName(afterReturningAnnotation.returning());
    //		}
    //		break;
    //	case AtAfterThrowing:
    //		springAdvice = new AspectJAfterThrowingAdvice(candidateAdviceMethod, expressionPointcut, aspectInstanceFactory);
    //		AfterThrowing afterThrowingAnnotation = (AfterThrowing) aspectJAnnotation.getAnnotation();
    //		if (StringUtils.hasText(afterThrowingAnnotation.throwing())) {
    //			springAdvice.setThrowingName(afterThrowingAnnotation.throwing());
    //		}
    //		break;
    //	}
}
