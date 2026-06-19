package example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceClassAspect {

    // 只针对某个方法进行拦截
    @Pointcut("execution(* example.component.ServiceClass.printSomething(..))")
    private void pointCutPrinting() {
    }

    // 通过JoinPoint获取方法参数
    @After(value = "pointCutPrinting()")
    public void publishPrintMessage(JoinPoint joinPoint) {
        System.out.println("after pointcut printing");
    }
}