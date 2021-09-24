package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_aop.demo.AspectCalculation;
import spring_aop.demo.FastCalculation;

// @EnableAspectJAutoProxy 注解如何实现AOP功能?
// 1. 首先会注册一个AnnotationAwareAspectJAutoProxyCreator组件，添加一个bean
// 2. 注册的bean AnnotationAwareAspectJAutoProxyCreator实现了BeanPostProcessor接口
//    在它的顶级父类AbstractAutoProxyCreator中实现的方法
//    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) { }
// 3. TODO: 什么时候将 @Before(value = "pointCut()") 这些解析出来，放到缓存中 ?
//    AbstractAutowireCapableBeanFactory.initializeBean()
//      applyBeanPostProcessorsBeforeInitialization()    初始化前 ==> 解析切面，放到缓存中
//      invokeInitMethods(beanName, wrappedBean, mbd);   初始化
//      applyBeanPostProcessorsAfterInitialization()     初始化后

// TODO: 解析AOP切面的时候，为什么要加缓存 ? 但是事务是不加缓存的
// 源码位置 > BeanFactoryAspectJAdvisorsBuilder
// 1. AOP解析切面源码功能中传入的是Object对象，表示从容器中获取所有组件的名称，然后在经过逐一遍历，加缓存是为了提高性能
// 2. 事务模块的功能是直接容器中获取Adviser类型，选择范围小，不需要添加缓存

@EnableAspectJAutoProxy(proxyTargetClass = false)
// 这里通过@Import({AspectJAutoProxyRegistrar.class})注册一个bean ==> 确定使用的后置处理器 !!
@Configuration // 主配置类，等效于beans.xml
@ComponentScan(basePackages = "spring_ioc.model") // 通过扫描component来注入bean
public class AppConfig {

    @Bean
    public FastCalculation fastCalculation() {
        return new FastCalculation();
    }

    @Bean
    public AspectCalculation aspectCalculation() {
        return new AspectCalculation();
    }
}
