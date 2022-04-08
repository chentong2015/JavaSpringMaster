package master.bean.bean_definition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;

// BeanFactoryPostProcessor
// 后置处理器的作用: 在bean还没有实例化之前修改bean定义的属性
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        // 修改拿到bean的bean定义属性中的class属性
        GenericBeanDefinition rootBeanDefinition =
                (GenericBeanDefinition) beanFactory.getBeanDefinition("instanceA");

        // 1. 最终从ioc中取出的bean是InstanceB, 此时容器中没有InstanceA
        //    InstanceA instanceA = context.getBean(InstanceA.class);
        // rootBeanDefinition.setBeanClass(InstanceB.class);

        // 2. 在此处设置注入模型，替代Component中添加的@Autowired注解
        rootBeanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        // 3. 修改bean的无参构造器的调用
        // TODO: 设置bean在被扫描被构造的时候，需要调用什么构造器(第一个参数必须是String类型的)
        GenericBeanDefinition genericBeanDefinition =
                (GenericBeanDefinition) beanFactory.getBeanDefinition("baseBeanDefinition");
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0, "name");
        genericBeanDefinition.setConstructorArgumentValues(constructorArgumentValues);
    }
}
