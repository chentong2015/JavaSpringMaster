package bean_import;

import bean_import.model.MyBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// TODO. 三种注入bean(A simple Java Object)的方式
// 1. 自定义通过@Import注解来注入
//    - 引入其他的配置类@Import(AnotherConfiguration.class)
//    - 直接注入类型MyBean.class
//    - 自定义实现ImportSelector进行批量注入
//    - 自定义实现ImportBeanDefinitionRegistrar注册器来匹配注入bean定义
// 2. Spring IOC自动装配
//    - ComponentScan 自动扫描特殊注解进行注入
//    - AutoConfigurationImportSelector 自动装配默认路径下所有预定义bean
//      \META-INF\spring.factories
@Import(value = {MyBean.class, CustomBeanDefinitionRegister.class, CustomImportSelector.class})
@Configuration
public class ImportBean {
}
