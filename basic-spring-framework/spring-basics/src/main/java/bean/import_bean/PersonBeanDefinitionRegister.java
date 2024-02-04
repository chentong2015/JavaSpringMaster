package bean.import_bean;

import bean.import_bean.model.MyBean;
import bean.import_bean.model.MyBeanWithConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

// 必须实现指定的接口implements ImportBeanDefinitionRegistrar
public class PersonBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    // 在ioc扫描bean并注册时，会自动的调用这个方法
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(MyBean.class);
        registry.registerBeanDefinition("myBean", rootBeanDefinition);
    }

    // 在添加bean定义的过程中，传入构造器参数
    public void registerBeanDefinitionWithParameters(BeanDefinitionRegistry registry, String name) {
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MyBeanWithConstructor.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(name);
        beanDefinition.setRole(BeanDefinition.ROLE_APPLICATION);
        registry.registerBeanDefinition("myBeanWithConstructor", beanDefinition);
    }
}
