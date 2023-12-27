package annotation;

import annotation.bean.MyBean;
import annotation.config.SpringAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Spring能够更好的管理java中的对象，相当于对象的管理者 !!
// 被Spring管理的对象才能完成自动注入，依赖注入

// Spring IoC: 依赖注入 --> 控制反转
// 1. 谁控制谁: IoC容器控制bean的声明周期
// 2. 控制什么: Bean(对象)
// 3. 为什么要控制: 解耦，依赖抽象
// 4. 那些方面反转: 创建的权利反转，交给容器来托管
public class SpringIocConfiguration {

    // 如何理解Spring IoC容器?  Spring IOC Container是什么?
    // BeanFactory IoC容器 : 完成一序列功能的一系列组件共同构成IOC容器
    // FactoryBean bean工厂: getObject()从容器中返回的对象由这个对象确定

    // SingletonObjects  单例缓存池(存放bean对象的), 使用ConcurrentHashMap类型, 多个线程可以使用Spring中同一个单例缓存池
    // BeanDefinitionMap bean定义对象存储地方
    // BeanFactoryPostProcessor
    // BeanPostProcess   bean后置处理器的集合
    // ...

    // ApplicationContext:
    // 1. 构建于Core和Bean之上，提供国际化，资源加载等高级支持，非延时加载
    // 2. (包含)BeanFactory: 实现基础的bean, 控制反转，延时加载
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(SpringAppConfig.class)) {
            MyBean bean = context.getBean(MyBean.class);
            bean.print();
        }
    }
}
