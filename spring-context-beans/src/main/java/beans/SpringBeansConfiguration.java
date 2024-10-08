package beans;

import beans.bean_import.bean.MyBean;
import beans.bean_import.bean.MyBeanCtor;
import beans.condition.OnWindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

// TODO. Configuration配置器
// 1. 使用@Import来导入配置类@Configuration (包含bean的声明)
// 2. 使用@Import来引入Register.class和Selector.class (自定义Bean的选择和注册)

// @Import(value = {AnotherImportConfiguration.class})
// @Import(value = {CustomBeanDefinitionRegister.class, CustomImportSelector.class})
@Configuration
public class SpringBeansConfiguration {

    // 基于特定的matches条件来注入bean
    @Bean
    @Conditional(OnWindowsCondition.class)
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBeanCtor testAutoInjection(MyBean myBean) {
        myBean.print();
        System.out.println("Auto Inject @Bean");
        return new MyBeanCtor("name");
    }
}
