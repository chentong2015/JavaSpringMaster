package example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutAspect {

    // TODO. @Pointcut切入点 + @Advice前后逻辑
    // Join point always represents a method execution.
    @Pointcut("execution(* example.component.PointCutClass.printSomething(..))")
    private void pointCutPrinting() {
    }

    @After(value = "pointCutPrinting()")
    public void publishPrintMessage(JoinPoint joinPoint) {
        System.out.println("after pointcut printing");
    }

    // TODO. @Pointcut切入点组后表达
    @Pointcut("@target(org.springframework.stereotype.Repository)")
    public void repositoryMethods() {}

    @Pointcut("execution(* *..create*(Long,..))")
    public void firstLongParamMethods() {}

    @Pointcut("repositoryMethods() && firstLongParamMethods()")
    public void entityCreationMethods() {}
}