package spring_aop;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.demo.Calculation;

// Spring AOP完整教程
// https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html

// Spring AOP的实现
// class com.sun.proxy.$Proxy20 创建的动态代理对象
// Proxy20 extends Proxy implements Calculation 生成的动态代理类(class文件)必须实现指定接口

// 1. 代理对象存储在那里: singletonObjects
// 2. 代理对象何时生成
// 3. 目标对象
public class BaseSpringAOP {

    // AnnotationConfigApplicationContext.AnnotationConfigApplicationContext(Class<?>... componentClasses)
    // AbstractApplicationContext.refresh()
    //   AbstractApplicationContext.finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory)
    //   DefaultListableBeanFactory.preInstantiateSingletons()

    // AbstractBeanFactory.getBean(String name)
    // AbstractBeanFactory.doGetBean(name, null, null, false);
    //    DefaultSingletonBeanRegistry.getSingleton(beanName);
    //    AbstractBeanFactory.createBean()

    // 源码分析入口: Spring AOP
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculation calculation = context.getBean(Calculation.class);
        int result = calculation.add(10, 10);
    }
}
