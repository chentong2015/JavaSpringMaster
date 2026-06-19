package example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// TODO. 抽离类型不能创建对象, 无法成为Proxy代理类对象
@Aspect
@Component
public abstract class AbstractAspect {

    @AfterReturning("execution(void example.component.HelloComponent.hello())")
    public void beforeHello(JoinPoint joinPoint) {
        System.out.println("before " + joinPoint);
    }
}
