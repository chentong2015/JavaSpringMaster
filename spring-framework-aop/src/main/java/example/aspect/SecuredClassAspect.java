package example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import example.bean.Secured;

@Aspect
public class SecuredClassAspect {

    // 拦截特殊自定义注解方法的调用
    @Before("@annotation(secured)")
    public void before(JoinPoint jp, Secured secured) {
        System.out.println("Before：" + jp.getSignature());
        System.out.println("isLocked = " + secured.isLocked());
    }

    @Around("@annotation(secured)")
    public Object around(ProceedingJoinPoint pjp, Secured secured) throws Throwable {
        System.out.println("Inside：" + pjp.getSignature());
        if (secured.isLocked()) {
            System.out.println("locked by aspect");
        }
        return pjp.proceed();
    }
}
