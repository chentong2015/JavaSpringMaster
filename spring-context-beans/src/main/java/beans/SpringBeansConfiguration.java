package beans;

import beans.bean_import.bean.MyBean;
import beans.bean_import.condition.OnWindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

// TODO. Configuration配置器中引入Register.class和Selector.class
// @Import(value = {AnotherImportConfiguration.class})
// @Import(value = {CustomBeanDefinitionRegister.class, CustomImportSelector.class})
@Configuration
public class SpringBeansConfiguration {

    // 在引入Bean之前判断是否基于某种条件
    @Bean
    @Conditional(OnWindowsCondition.class)
    public MyBean myBean() {
        return new MyBean();
    }
}
