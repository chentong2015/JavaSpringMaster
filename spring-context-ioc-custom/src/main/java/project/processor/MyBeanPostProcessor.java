package project.processor;

import com.spring.annotation.Component;
import com.spring.interfacz.BeanPostProcessor;
import project.service.UserService;

import java.lang.reflect.Proxy;

// 1. 特殊的bean需要被注入
// 2. 针对所有的bean的创建过程做自定义处理
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 过滤指定bean, 方法返回的对象不一定是传入的bean对象(可以被修改)
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization");
        if (beanName.equals("userService")) {
            ((UserService) bean).testBeanPostProcessor();
        }
        return bean;
    }

    // TODO. 使用后置处理器在创建bean的初始化后生成代理对象，完成AOP逻辑
    //  找出bean对应的所有要执行的Aspect切面方法pointcut，保存到代理对象中
    //  在调用返回的代理对象方法时，执行相应的Aspect切面方法
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("postProcessAfterInitialization");
        // 需要判断bean是否需要进行AOP
        if (beanName.equals("proxyComponentImpl")) {
            // 生成代理对象并执行额外的逻辑(Aspect切面逻辑)
            return Proxy.newProxyInstance(
                    MyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("Component proxy calling");
                        return method.invoke(bean, args);
                    }
            );
        }
        return bean;
    }
}
