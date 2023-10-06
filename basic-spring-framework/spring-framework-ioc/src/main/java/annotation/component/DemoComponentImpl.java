package annotation.component;

import org.springframework.stereotype.Component;

// @Component 作为注入到Spring container中的bean来使用
// @Component("demoComponent")
// 可以指定名称，Spring默认使用类型的名称"demoComponentImpl"(首字母小写)来作为bean id
@Component
public class DemoComponentImpl implements DemoComponent {

    @Override
    public void testBeanAsComponent() {
        System.out.println("Bean as component");
    }
}
