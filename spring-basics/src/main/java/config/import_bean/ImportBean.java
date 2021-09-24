package config.import_bean;

import org.springframework.context.annotation.Import;

// @Configuration
// 通过import扫描加载到ioc容器中，完成注入
@Import(value = PersonBeanDefinitionRegister.class)
public class ImportBean {
}
