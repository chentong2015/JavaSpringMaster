package example.bean;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
public class AroundBean {

    // TODO. 有AOP代理对象调用, 实现Aspect切面效果
    public void hello() {
        System.out.println("in hello");
    }

    // TODO. 使用AopContext获取到代理对象, 等效触发Aspect效果
    // Set 'exposeProxy' property on Advised to 'true' to make it available,
    // and ensure that AopContext.currentProxy() is invoked in the same thread as the AOP invocation context.
    public void helloByProxy() {
        Object objectProxy = AopContext.currentProxy();
        ((AroundBean) objectProxy).hello();
    }
}
