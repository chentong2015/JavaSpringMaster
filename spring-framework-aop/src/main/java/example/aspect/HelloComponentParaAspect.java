package example.aspect;

import example.model.MainItem;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloComponentParaAspect {

    @After("execution(void example.component.HelloComponent.helloItem(..))")
    public void afterHello(JoinPoint joinPoint) {
        MainItem item = (MainItem) joinPoint.getArgs()[0];

        System.out.println("after hello: " + item.isCleanup());
        System.out.println("after hello: " + item.getValue());
    }
}
