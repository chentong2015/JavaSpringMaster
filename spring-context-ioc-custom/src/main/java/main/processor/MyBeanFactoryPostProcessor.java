package main.processor;

import com.spring.factory.CustomBeanFactory;
import com.spring.processor.BeanFactoryPostProcessor;

// TODO. BeanFactoryPostProcessor Bean工厂后置处理器
// 在IOC中的BeanFactory初始化完成后，在Bean被创建之前修改Bean相关的属性
// 对于针对系统管理员的自定义配置文件很有用，这些配置文件会覆盖在应用程序上下文中配置的bean属性
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // Modify the application context's internal bean factory after its standard initialization.
    // All bean definitions will have been loaded, but no beans will have been instantiated yet.
    // This allows for overriding or adding properties even to eager-initializing beans.
    @Override
    public void postProcessBeanFactory(CustomBeanFactory beanFactory) {
        System.out.println("Update scope for bean definition of myBean");
        beanFactory.getBeanDefinition("myBean").setScope("prototype");
    }
}
