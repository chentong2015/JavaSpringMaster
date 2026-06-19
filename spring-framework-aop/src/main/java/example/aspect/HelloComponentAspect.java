package example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloComponentAspect {

    @Before("execution(void example.component.HelloComponent.hello())")
    public void beforeHello(JoinPoint joinPoint) {
        System.out.println("before " + joinPoint);
    }

    // @Around 定义被拦截的方法所执行的前后文
    // execution() 定义被拦截的方法的原型
    @Around("execution(void example.component.HelloComponent.hello())")
    public void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("in around before " + joinPoint);
        // JoinPoint连接点: 指定被拦截的方法的主体逻辑
        joinPoint.proceed();
        System.out.println("in around after " + joinPoint);
    }

    @After("execution(void example.component.HelloComponent.hello())")
    public void afterHello(JoinPoint joinPoint) {
        System.out.println("after " + joinPoint);
    }
}
