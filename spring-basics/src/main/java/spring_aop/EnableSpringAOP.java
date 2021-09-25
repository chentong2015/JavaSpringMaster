package spring_aop;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_aop.aspect_base.Calculation;

// @EnableAspectJAutoProxy 注解如何实现AOP功能?
// 1. 首先会注册一个AnnotationAwareAspectJAutoProxyCreator组件，添加一个bean ==> 确定使用的后置处理器
// 2. 注册的bean AnnotationAwareAspectJAutoProxyCreator实现了BeanPostProcessor接口
//    在它的顶级父类AbstractAutoProxyCreator中实现的方法
//    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) { }
// 3. 什么时候将@Before(value = "pointCut()")解析出来，放到缓存中 ?
//    AbstractAutowireCapableBeanFactory.initializeBean()
//      applyBeanPostProcessorsBeforeInitialization()    初始化前 ==> 解析切面，放到缓存中
//      invokeInitMethods(beanName, wrappedBean, mbd);   初始化
//      applyBeanPostProcessorsAfterInitialization()     初始化后

// TODO: AOP如何解析切面 ?
// BeanFactoryAspectJAdvisorsBuilder.buildAspectJAdvisors()
// 1. 从容器中获取所有的bean进行遍历，从bean的名称中获取class对象，然后判断是否标注@Aspect注解，如果是则为切面类型
// 2. 通过利用反射拿到method上的注解，判断不同的注解类型@Before, @After
// 3. 根据不同的注解类型创建指定类型的对象，保存到advisorsCache缓存中

// TODO: AOP解析切面时为什么要加缓存? 但是事务不加缓存 ?
// 源码位置 > BeanFactoryAspectJAdvisorsBuilder
// 1. AOP解析切面源码功能中传入的是Object对象，表示从容器中获取所有组件的名称，然后在经过逐一遍历，加缓存是为了提高性能
// 2. 事务模块的功能是直接容器中获取Adviser类型，选择范围小，不需要添加缓存

@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
public class EnableSpringAOP {

    // TODO: 使用了工厂模式和动态代理模式(两种)
    // 1. JdkDynamicAopProxy: 适用于代理的类型实现了接口
    //    Proxy.newProxyInstance(classLoader, this.proxiedInterfaces, this);
    // 2. CglibAopProxy: 适用于代理的类型没有实现接口
    //    默认配置@EnableAspectJAutoProxy(proxyTargetClass = false)，不使用cglib代理，true表示使用
    //
    //    源码 DefaultAopProxyFactory.createAopProxy()
    //    @Override
    //	  public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
    //	 	if (!NativeDetector.inNativeImage() && (config.isOptimize() ||
    //	      	config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config))) {
    //	 		Class<?> targetClass = config.getTargetClass();
    //	 		... 如果实现了接口，则选择JdkDynamicAopProxy代理模式 !!
    //	 		if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
    //	 			return new JdkDynamicAopProxy(config);
    //	 		}
    //	 		return new ObjenesisCglibAopProxy(config);
    //	 	}	else {
    //	 		return new JdkDynamicAopProxy(config);
    //	 	}
    //	  }

    // TODO: exposeProxy: 配置是否将proxy暴露到ThreadLocal
    // Proxy should be exposed by the AOP framework as a ThreadLocal for retrieval via the AopContext class.
    // 指示代理应由AOP框架公开为ThreadLocal(线程本地存储)以通过AopContext类进行检索
    // JdkDynamicAopProxy.invoke()
    // 	if (this.advised.exposeProxy) {
    //		// 保存了之前老的proxy，用于在finally中恢复
    //		oldProxy = AopContext.setCurrentProxy(proxy);
    //		setProxyContext = true;
    //	}
    //
    // exposeProxy=true; 从线程变量中取出代理对象，然后调用方法，则同样会被切入(被增强)
    // exposeProxy=false; 该方法的调用this.add(10, 10);不会被增强
    public int div(int num1, int num2) {
        System.out.println("Call div");
        int value1 = ((Calculation) AopContext.currentProxy()).add(10, 10);
        // int value2 = this.add(10, 10);
        return 0;
    }
}
