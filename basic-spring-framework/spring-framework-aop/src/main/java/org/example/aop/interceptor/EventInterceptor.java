package org.example.aop.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 面向方面编程可用于设计拦截器
@Aspect
@Component
public class EventInterceptor {

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
