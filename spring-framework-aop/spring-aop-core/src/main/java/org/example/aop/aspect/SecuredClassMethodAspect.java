package org.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.aop.bean.Secured;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecuredClassMethodAspect {

    // 拦截有特殊自定义注解方法的调用
    @Pointcut("@annotation(secured)")
    public void callAt(Secured secured) {
    }

    @Around(value = "callAt(secured)", argNames = "pjp,secured")
    public Object around(ProceedingJoinPoint pjp, Secured secured) throws Throwable {
        System.out.println("Around Secure: " + secured.isLocked());
        return secured.isLocked() ? null : pjp.proceed();
    }
}
