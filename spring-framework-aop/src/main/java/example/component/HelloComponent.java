package example.component;

import example.model.MainItem;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Component
public class HelloComponent {

    // TODO. 被AOP代理对象调用, 实现Aspect切面效果
    public void hello() {
        System.out.println("in hello");
    }

    // TODO. 使用AopContext获取到代理对象并触发Aspect效果
    // Set 'exposeProxy' property on Advised to 'true' to make it available,
    // and ensure that AopContext.currentProxy() is invoked in the same thread as the AOP invocation context.
    public void helloByProxy() {
        Object objectProxy = AopContext.currentProxy();
        ((HelloComponent) objectProxy).hello();
    }

    // 拦截方法执行完后的属性值变化
    public void helloItem(MainItem item) {
        System.out.println("inside hello: " + item.isCleanup());
        item.setCleanup(true);
    }

    // TODO. 私有方法无法通过AOP在类外部调用
    private void helloPrivate() {
        System.out.println("Hello private");
    }
}
