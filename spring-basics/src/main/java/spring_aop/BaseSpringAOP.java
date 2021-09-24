package spring_aop;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_aop.demo.Calculation;

// https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html
// Spring AOP的底层实现
// class com.sun.proxy.$Proxy20 创建的动态代理对象
// Proxy20 extends Proxy implements Calculation 生成的动态代理类(class文件)必须实现指定接口
// TODO: 使用了工厂模式和动态代理模式(两种)
// 1. JdkDynamicAopProxy: Proxy.newProxyInstance(classLoader, this.proxiedInterfaces, this);
//    该模式适用于代理的类型实现了接口 !!
// 2. CglibAopProxy
//    TODO: 如果代理的类型没有实现接口，则需要使用该代理模式
//    默认配置@EnableAspectJAutoProxy(proxyTargetClass = false)，不使用cglib代理，可以自定义设置成true

// 源码 DefaultAopProxyFactory.createAopProxy()
//  @Override
//	public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
//		if (!NativeDetector.inNativeImage() && (config.isOptimize() ||
//	     	config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config))) {
//			Class<?> targetClass = config.getTargetClass();
//			... 如果实现了接口，则选择JdkDynamicAopProxy代理模式 !!
//			if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
//				return new JdkDynamicAopProxy(config);
//			}
//			return new ObjenesisCglibAopProxy(config);
//		}	else {
//			return new JdkDynamicAopProxy(config);
//		}
//	}
public class BaseSpringAOP {

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
    //          proxyFactory.getProxy(classLoader); 两种代理模式的使用

    // 源码分析入口: Spring AOP
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Calculation calculation = context.getBean(Calculation.class);
        int result = calculation.add(10, 10);
    }
}
