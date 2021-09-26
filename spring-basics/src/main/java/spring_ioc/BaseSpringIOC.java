package spring_ioc;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_ioc.model.MyBean;

// Spring IOC: 依赖注入 --> 控制反转
// 1. 谁控制谁: IOC容器控制bean的声明周期
// 2. 控制什么: Bean(对象)
// 3. 为什么要控制: 解耦，依赖抽象
// 4. 那些方面反转: 创建的权利反转，交给容器来托管

// Spring 依赖查找:
// UserController {
//   Map<String, IRule> 使用接口
// }
public class BaseSpringIOC {

    // ApplicationContext: 构建于Core和Bean之上
    // 提供国际化，资源加载等高级支持，非延时加载
    // (包含) BeanFactory: 实现基础的bean, 控制反转，延时加载

    // beanDefinition 通过注解来描述bean的行为和信息
    // AbstractBeanDefinition.java ==> 存放在BeanDefinitionMap
    // @Lazy
    // @DependsOn
    // @Scope

    // TODO: IOC Container，完成一序列功能的一系列组件共同构成IOC容器，都在BeanFactory中
    // BeanDefinitionMap
    // SingletonObjects  单例缓存池
    // BeanPostProcess
    // ...

    // bean的后置处理器BeanPostProcessors
    // 1. 通过后置处理器在对象初始化前后，修改对象的属性值和特征
    // AbstractAutowireCapableBeanFactory.initializeBean()
    //    applyBeanPostProcessorsBeforeInitialization()   初始化前
    //    invokeInitMethods(beanName, wrappedBean, mbd);  初始化
    //    applyBeanPostProcessorsAfterInitialization()    初始化后

    // interface InitializingBean生命周期的回调
    // @PostConstruct
    // @PreDestroy

    // 源码分析入口: Spring Beans + Spring Context
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean bean = context.getBean(MyBean.class);
        bean.print();
    }
}
