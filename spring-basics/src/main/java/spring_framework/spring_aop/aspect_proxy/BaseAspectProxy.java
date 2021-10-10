package spring_framework.spring_aop.aspect_proxy;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Spring AOP的底层实现
// class com.sun.proxy.$Proxy20 创建的动态代理对象
// Proxy20 extends Proxy implements Calculation 生成的动态代理类(class文件)必须实现指定接口

// 默认配置@EnableAspectJAutoProxy(proxyTargetClass = false)，不使用cglib代理，true表示使用
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
public class BaseAspectProxy {

    // TODO: 使用了工厂模式和动态代理模式(两种)
    // 1. JdkDynamicAopProxy: 适用于代理的类型实现了接口
    //    Proxy.newProxyInstance(classLoader, this.proxiedInterfaces, this);
    // 2. CglibAopProxy: 适用于代理的类型没有实现接口, 基于继承
    //    源码 DefaultAopProxyFactory.createAopProxy()
    //    @Override
    //	  public AopProxy createAopProxy(AdvisedSupport main.config) throws AopConfigException {
    //	 	if (!NativeDetector.inNativeImage() && (main.config.isOptimize() ||
    //	      	main.config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(main.config))) {
    //	 		Class<?> targetClass = main.config.getTargetClass();
    //	 		... 如果实现了接口，则选择JdkDynamicAopProxy代理模式 !!
    //	 		if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
    //	 			return new JdkDynamicAopProxy(main.config);
    //	 		}
    //	 		return new ObjenesisCglibAopProxy(main.config);
    //	 	}	else {
    //	 		return new JdkDynamicAopProxy(main.config);
    //	 	}
    //	  }

    // CglibAopProxy使用原理: https://cloud.tencent.com/developer/article/1461796
    // > 代理对象只存在JVM中，不在spring的容器中
    // > 基于父子类来进行动态代理的，生成的代理类继承原始类(原始类不能用final来修饰)
    // > TODO: 基于"ASM字节码"生成库, 允许在运行时对字节码进行修改和动态生成
    // class FastCalculationProxy extends FastCalculation {
    //     FastCalculation target; 容器中bean的原始对象，作为代理对象的属性
    //     1. 执行代理逻辑(切面方法)
    //          joinPoint.getTarget(); 拿到是"原始对象"
    //     2. 执行业务方法逻辑
    //          super.method();  一般不使用
    //          target.method(); 原始对象中是经过了bean后面的初始化周期步骤，所以属性是有值的
    // }
}
