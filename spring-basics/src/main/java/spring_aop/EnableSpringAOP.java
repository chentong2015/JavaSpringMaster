package spring_aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

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

// TODO: 如何解析切面 ?
// 1. 从容器中获取所有的bean，进行遍历，从bean的名称中获取class对象，然后判断是否标注@Aspect注解，如果是则为切面类型
// 2. 通过利用反射拿到method上的注解，判断不同的注解类型@Before, @After

// TODO: 解析AOP切面的时候，为什么要加缓存? 但是事务是不加缓存的
// 源码位置 > BeanFactoryAspectJAdvisorsBuilder
// 1. AOP解析切面源码功能中传入的是Object对象，表示从容器中获取所有组件的名称，然后在经过逐一遍历，加缓存是为了提高性能
// 2. 事务模块的功能是直接容器中获取Adviser类型，选择范围小，不需要添加缓存

// exposeProxy: proxy should be exposed by the AOP framework as a ThreadLocal for retrieval via the AopContext class.
// 指示代理应由AOP框架公开为ThreadLocal(线程本地存储)以通过AopContext类进行检索
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = false)
public class EnableSpringAOP {

}
