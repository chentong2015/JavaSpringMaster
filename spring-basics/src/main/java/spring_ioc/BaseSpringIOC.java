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

    // TODO: Spring IOC Container 是什么? 完成一序列功能的一系列组件共同构成IOC容器，都在BeanFactory中
    // BeanDefinitionMap bean定义对象
    // SingletonObjects  单例缓存池
    // BeanPostProcess   bean后置处理器的集合
    // ...

    // ApplicationContext:
    // 1. 构建于Core和Bean之上，提供国际化，资源加载等高级支持，非延时加载
    // 2. (包含) BeanFactory: 实现基础的bean, 控制反转，延时加载

    // 源码分析入口: Spring Beans + Spring Context
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean bean = context.getBean(MyBean.class);
        bean.print();
    }
}
