package bean_import.condition;

import bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConditionBeanConfiguration {

    // 基于特定的matches条件来注入bean
    @Bean
    @Conditional(OnWindowsCondition.class)
    public MyBean myBean() {
        return new MyBean();
    }
}
