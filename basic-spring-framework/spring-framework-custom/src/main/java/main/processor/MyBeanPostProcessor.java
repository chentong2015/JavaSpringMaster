package main.processor;

import com.spring.annotation.Component;
import com.spring.interfacz.BeanPostProcessor;
import main.service.UserService;

// TODO. bean的后置处理器(也需要被注入，是特殊的bean)
//  针对所有的bean的创建过程做自定义处理
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 过滤处理指定的bean
    // 方法返回的对象不一定是传入的bean对象(可以被修改)
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization");
        if (beanName.equals("userService")) {
            ((UserService) bean).testBeanPostProcessor();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }
}
