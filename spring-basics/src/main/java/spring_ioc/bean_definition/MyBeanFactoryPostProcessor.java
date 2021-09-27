package spring_ioc.bean_definition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import spring_ioc.bean_definition.model.InstanceB;

// BeanFactoryPostProcessor在bean还没有实例化之前修改bean定义的属性
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 修改拿到bean的bean定义属性中的class属性
        GenericBeanDefinition rootBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("instanceA");
        rootBeanDefinition.setBeanClass(InstanceB.class);

        // 最终从ioc中取出的bean是InstanceB, 此时容器中没有InstanceA
        // InstanceA instanceA = context.getBean(InstanceA.class);
    }
}
