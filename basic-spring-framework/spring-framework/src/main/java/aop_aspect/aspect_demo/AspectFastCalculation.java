package aop_aspect.aspect_demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

// 将相同功能的"非业务代码"抽象到指定类型中
// Order注解指定多个切面的执行顺序，数值越大优先级越低，默认Integer.MAX_VALUE
// TODO: 默认自定义的切面和事务的切面优先级一致，和源码解析的顺序一致 / 可以设置自定义的切面优先级更高
@Aspect
@Order(value = 10)
public class AspectFastCalculation {

    // 代理对象如何调用到目标方法 ?
    // 设计精髓: 通过5个结点放到链条中，通过"责任链+递归"的方式驱动执行，0驱动1，1驱动2，，，

    // TODO: 将链接器中的advisor(@Before, @After..)取出来，转成拦截器的链条
    //       链条中保存的顺序就时执行的顺序(spring会控制排序)
    // JdkDynamicAopProxy.invoke()
    // 0. ExposeInvocationInterceptor
    // 1. AspectAfterThrowingAdvice
    // 2. AfterReturningAdvice
    // 3. AspectAfterAdvice
    // 4. MethodBeforeAdviceInterceptor
    // List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);

    // 切入点：调用指定类型中的所有方法
    @Pointcut("execution(* aop_aspect.aspect_demo.model.FastCalculation.*(..))")
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

    // 3. 返回通知 ==> 正常的return
    //    AfterReturningAdviceInterceptor类型
    //    public Object invoke(MethodInvocation mi) throws Throwable {
    //		// TODO：如果在这里抛出异常，往上抛出，则后面的afterReturning返回通知不会被执行到
    //               mi.proceed()该方法往内层调用，如果目标方法抛出异常，则往上跑，不会执行后面的语句
    //		Object retVal = mi.proceed();
    //		this.advice.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
    //		return retVal;
    //	  }
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
