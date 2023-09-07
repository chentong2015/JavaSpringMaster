package aop_aspect;

import aop_aspect.aspect_demo.model.Calculation;
import config.AppContainerConfig;
import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 该注解会注册一个AnnotationAwareAspectJAutoProxyCreator bean组件
// 该组件实现了BeanPostProcessor接口 ==> 确定使用的后置处理器
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
public class SpringAop {

    // TODO: Spring如何判断Service类/原始对象需要执行AOP? 是否有切面?
    // Aspect切面本身是一个bean，会添加到Spring容器中
    // 1. 从Spring容器中找出所有切面bean，全部遍历
    // 2. 遍历每一个切面bean的所有方法，是否有对应的切面(匹配)
    // 3. 如果有，则保存切面方法(代理逻辑)到代理类型，之后会执行
    // TODO: AOP如何解析切面 ?
    // BeanFactoryAspectJAdvisorsBuilder.buildAspectJAdvisors()
    // 1. 从容器中获取所有的bean进行遍历，从bean的名称中获取class对象，然后判断是否标注@Aspect注解，如果是则为切面类型
    // 2. 通过利用反射拿到method上的注解，判断不同的注解类型@Before, @After
    // 3. 根据不同的注解类型创建指定类型的对象，保存到advisorsCache缓存中

    // TODO: AOP解析切面时为什么要加缓存? 但是事务不加缓存 ?
    // 源码位置 > BeanFactoryAspectJAdvisorsBuilder
    // 1. AOP解析切面源码功能中传入的是Object对象，表示从容器中获取所有组件的名称，然后逐一遍历，加缓存是为了提高性能
    // 2. 事务模块的功能是直接容器中获取Adviser类型，选择范围小，不需要添加缓存

    // TODO: exposeProxy: 配置是否将proxy暴露到ThreadLocal
    // Proxy should be exposed by the AOP framework as a ThreadLocal for retrieval via the AopContext class.
    // 指示代理应由AOP框架公开为ThreadLocal(线程本地存储), 之后通过AopContext类来进行检索
    // JdkDynamicAopProxy.invoke()
    // 	if (this.advised.exposeProxy) {
    //		保存之前老的proxy，用于在finally中恢复
    //		oldProxy = AopContext.setCurrentProxy(proxy);
    //		setProxyContext = true;
    //	}
    // exposeProxy=true;  从线程变量中取出代理对象，然后调用方法，同样会被切入(被增强)
    // exposeProxy=false; 该方法的调用this.add(10, 10);不会被增强
    public int div(int num1, int num2) {
        System.out.println("Call div");
        int value1 = ((Calculation) AopContext.currentProxy()).add(10, 10);
        // int value2 = this.add(10, 10);
        return 0;
    }

    // 源码分析入口: Spring AOP
    // AnnotationConfigApplicationContext.AnnotationConfigApplicationContext(Class<?>... componentClasses)
    // AbstractApplicationContext.refresh()
    //   AbstractApplicationContext.finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory)
    //   DefaultListableBeanFactory.preInstantiateSingletons()
    //
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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContainerConfig.class);
        // 1. 拿到返回的代理对象，对象其中一些属性(@Autowired)是为null的
        Calculation calculation = context.getBean(Calculation.class);
        // 2. 通过代理对象调用(原始对象的)目标方法
        int result = calculation.add(10, 10);
    }
}
