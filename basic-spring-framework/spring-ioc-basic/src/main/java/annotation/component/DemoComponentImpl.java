package main.component;

import org.springframework.stereotype.Component;

/**
 * @Component 作为注入到Spring container中的bean来使用
 * 1. 注解只是作用在实现的类型上面，不作用在所实现的接口上 !!
 * 2. Not make interface dependent on Spring,
 * interface should be decoupled from the implementation 接口应该和具体的实现分离 !!
 * @Component("demoComponent") 可以指定名称，Spring默认使用类型的名称"demoComponentImpl"(首字母小写)来作为bean id
 */
@Component
public class DemoComponentImpl implements main.component.DemoComponent {

    @Override
    public void testBeanAsComponent() {
        System.out.println("Bean as component");
    }
}
