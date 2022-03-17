package bean.import_bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// Import Bean三种使用方式:
// 1. 直接注入bean到容器中，导入普通组件
//    @Import(value = {BaseBean.class})
//
// 2. 通过BeanDefinitionRegistrar来构建BeanDefinition再注册导入
//    @Import(value = PersonBeanDefinitionRegister.class)
//
// 3. 使用Spring Boot自动装配, 通过完整路径来import
@Import(value = {
        BaseBean.class,
        PersonBeanDefinitionRegister.class,
        PersonImportSelector.class})
@Configuration
public class ImportBean {

}
