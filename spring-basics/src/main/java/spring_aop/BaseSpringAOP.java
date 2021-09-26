package spring_aop;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.aspect_base.model.Calculation;

// Spring AOP的底层实现
// class com.sun.proxy.$Proxy20 创建的动态代理对象
// Proxy20 extends Proxy implements Calculation 生成的动态代理类(class文件)必须实现指定接口


public class BaseSpringAOP {

    // 源码分析入口: Spring AOP
    // AnnotationConfigApplicationContext.AnnotationConfigApplicationContext(Class<?>... componentClasses)
    // AbstractApplicationContext.refresh()
    //   AbstractApplicationContext.finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory)
    //   DefaultListableBeanFactory.preInstantiateSingletons()

    // AbstractBeanFactory.getBean(String name)
    // AbstractBeanFactory.doGetBean(name, null, null, false);
    //    DefaultSingletonBeanRegistry.getSingleton(beanName);
    //    AbstractBeanFactory.createBean()
    //       下面的方法返回了代理对象
    //       AbstractAutowireCapableBeanFactory.doCreateBean(beanName, mbdToUse, args)
    //       AbstractAutowireCapableBeanFactory.initializeBean(beanName, exposedObject, mbd);
    //       AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
    //          AbstractAutoProxyCreator.postProcessBeforeInstantiation()
    //          AbstractAutoProxyCreator.createProxy()
    //          proxyFactory.getProxy(classLoader);
    //          两种代理模式的使用
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 拿到返回的代理对象
        Calculation calculation = context.getBean(Calculation.class);
        // 2. 通过代理对象调用目标方法
        int result = calculation.add(10, 10);
    }
}
