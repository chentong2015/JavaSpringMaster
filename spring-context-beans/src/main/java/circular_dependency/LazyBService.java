package circular_dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// TODO: @Lazy添加注解延迟构造器属性的注入, 避免循环依赖死锁
//  生成AService的"代理对象(绕过AService类型的代理对象)"传递给构造器
//
// Instead of fully initializing the bean, it will create a proxy to inject it into the other bean.
// The injected bean will only be fully created when it’s first needed.
//
// Lazy initialization means that Spring will only create and inject the bean when it’s needed,
// rather than eagerly initializing it at startup.

@Component
public class LazyBService {

    private AService aService;

    @Lazy
    public LazyBService(AService aService) {
        this.aService = aService;
    }

    // TODO. 调用代理对象的方法，进入到代理逻辑，找真正的AService对象
    public void testAService() {
        aService.test();
    }
}
