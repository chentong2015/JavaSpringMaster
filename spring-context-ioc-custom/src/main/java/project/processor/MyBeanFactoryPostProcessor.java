package project.processor;

import com.spring.factory.CustomBeanFactory;
import com.spring.processor.BeanFactoryPostProcessor;

// TODO. Bean工厂后置处理器
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // 在BeanFactory初始化完成后，在Bean被创建之前修改Bean属性
    // Modify the application context's internal bean factory after its standard initialization.
    // All bean definitions will have been loaded, but no beans will have been instantiated yet.
    // This allows for overriding or adding properties even to eager-initializing beans.
    @Override
    public void postProcessBeanFactory(CustomBeanFactory beanFactory) {
        System.out.println("Update scope for bean definition of myBean");
        beanFactory.getBeanDefinition("MyBean").setScope("prototype");
    }
}
