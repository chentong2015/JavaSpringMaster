package annotation;

import annotation.component.DemoComponent;
import annotation.config.AppContainerConfig;
import annotation.config.MyDateSource;
import annotation.lifecycle.NumberGenerator;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean (Simple java object): beans are created with the configuration metadata that you supply to the container
 * Spring IoC Container     : component of Spring framework that contains beans and manage their lifecycle
 * .
 * 1. 添加Spring Context Dependency到POM配置文件: Application Context ==> Spring Container Object
 * 2. 重新刷新maven(Reload all maven projects) : clean install package到本地仓库 !!!
 * 3. 构建bean配置文件：/resources/beans.xml    : 必须指定Configure Application Context到beans.xml !!! (勾选指定的xml文件)
 * 4. 通过xml配置文件注入到Spring Container中
 * .
 * 1. 使用Annotation Configuration来替代beans.xml的配置 !!
 */
public class BaseIoCContainer {

    /**
     * ApplicationContext继承自ApplicationEventPublisher(封装了event功能), 作为ApplicationContext的附加能力
     * Event handling事件处理机制需要使用
     * 1. ApplicationEvent abstract class 所的Event都必须直接或者间接的继承自该抽象类
     * 2. ApplicationListener interface
     */
    public static void main(String[] args) {
        // Loaded bean definitions from URL [file:src/main/resources/beans.xml]
        // ApplicationContext is created and initialized with JndiDataSource metadata beans.xml
        ConfigurableApplicationContext contextClassPath = new ClassPathXmlApplicationContext("beans.xml");

        /**
         * 使用接口来解耦: 从container中获取实现了指定接口的类型的实例对象
         * 1. Singleton Scope: 默认返回的是单列single instance of bean 整个应用中只有一个对象
         * 2. 可以根据bean id获取指定的bean, 或者get bean by type
         * 3. 测试bean的生命周期
         */
        // NumberGenerator numberGenerator = contextClassPath.getBean(NumberGenerator.class);
        // System.out.println(numberGenerator.nextRandomNumber());
        // NumberGenerator numberGenerator2 = contextClassPath.getBean("numberGenerator", NumberGenerator.class);
        // System.out.println(numberGenerator2.nextRandomNumber());

        // 测试依赖注入, 在构建对象时注入指定的bean
        // DependencyInjection dependencyInjection = contextClassPath.getBean(DependencyInjection.class);
        // dependencyInjection.testDependencyInjection();

        // 测试将bean作为Component, 在获取对象时使用默认bean id, 否则必须和自定义的id名称一致 !!
        DemoComponent demoComponent = contextClassPath.getBean(DemoComponent.class);
        demoComponent.testBeanAsComponent();

        // 测试从properties file中获取数据
        MyDateSource dateSource = contextClassPath.getBean("dataSource", MyDateSource.class);
        System.out.println(dateSource);

        // 关闭Spring Container, 其中的所有的bean将被销毁
        contextClassPath.close();
    }

    // 使用AnnotationConfig配置来提供spring container的配置
    private void testAnnotationConfiguration() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppContainerConfig.class);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        System.out.println(numberGenerator.nextRandomNumber());
    }
}
