package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// Aspect面向方面编程可用于设计拦截器
@Aspect
public class AspectEventInterceptor {

    @Pointcut("execution (public * *(..))")
    public void isPublic() {
    }

    @Pointcut("!isStatic()  && !toSkip() && (isPublic() || hasDescription())")
    public void fittingMethod() {
    }

    @Pointcut("execution (static * *(..))")
    public void isStatic() {
    }

    @Pointcut("execution (* get*(..)) || execution (* is*(..)) || execution (* has*(..))")
    public void isGetter() {
    }
}
