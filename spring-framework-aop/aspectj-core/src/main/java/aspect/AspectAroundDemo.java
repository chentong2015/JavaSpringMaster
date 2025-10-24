package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectAroundDemo {

    public static boolean runAround = true;

    public void hello() {
        System.err.println("in hello");
    }

    // execution() 定义被拦截的方法的原型
    @Around("execution(void org.example.aspect.AspectAroundDemo.hello())")
    public void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("in around before " + joinPoint);
        if (runAround) {
            // JoinPoint连接点: 指定被拦截的方法的主体逻辑
            joinPoint.proceed();
        }
        System.err.println("in around after " + joinPoint);
    }

    @Before("execution(void org.example.aspect.AspectAroundDemo.hello())")
    public void beforeHello(JoinPoint joinPoint) {
        System.err.println("before " + joinPoint);
    }

    @After("execution(void org.example.aspect.AspectAroundDemo.hello())")
    public void afterHello(JoinPoint joinPoint) {
        System.err.println("after " + joinPoint);
    }

    public static void main(String[] args) {
        new AspectAroundDemo().hello();
        runAround = false;
        new AspectAroundDemo().hello();
    }
}
