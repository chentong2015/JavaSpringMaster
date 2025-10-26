package main;

import com.spring.CustomApplicationContext;
import com.spring.model.BeanDefinition;
import main.bean.BeanPostConstruct;
import main.processor.MyBeanFactoryPostProcessor;
import main.proxy.ProxyComponent;
import main.service.UserService;

public class CustomSpringBootApplication {

    public static void main(String[] args) {
        CustomApplicationContext context = new CustomApplicationContext(CustomSpringBootConfig.class);
        context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        context.refresh();

        UserService userService = (UserService) context.getBean("userService");
        userService.test();

        // 由于在Bean后置处理器中生成了以下bean的代理对象
        // 1. 代理对象不能强制转换成具体的IComponentImpl对象
        // 2. 在调用test()方法时会执行额外的逻辑(被拦截的逻辑)
        ProxyComponent iComponent = (ProxyComponent) context.getBean("iComponentImpl");
        iComponent.test();

        BeanPostConstruct beanWithPostConstruct = (BeanPostConstruct) context.getBean("BeanPostConstruct");
        System.out.println(beanWithPostConstruct);

        // 检测bean定义是否被BeanFactoryPostProcessor后置处理器修改
        BeanDefinition beanDefinition = context.getBeanDefinition("myBean");
        System.out.println(beanDefinition.isSingleton());
        System.out.println(beanDefinition.isPrototype());
    }
}
