package bean.import_bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

// 必须实现指定的接口implements ImportBeanDefinitionRegistrar
public class PersonBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    // 在ioc扫描bean并注册时，会自动的调用这个方法
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Person.class);
        registry.registerBeanDefinition("person", rootBeanDefinition);
    }
}
