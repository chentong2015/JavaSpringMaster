package bean_import.condition;

import bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConditionBeanConfiguration {

    // TODO. @Conditional 条件注入
    // 基于特定的matches条件来选择注入bean对象
    // 属于是BeanDefinition阶段行为, 和bean实例化行为无关(不影响实例过程)
    @Bean
    @Conditional(OnWindowsCondition.class)
    public MyBean myBean() {
        return new MyBean();
    }
}
