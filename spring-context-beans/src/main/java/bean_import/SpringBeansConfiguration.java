package bean_import;

import bean.MyBean;
import bean.MyBeanCtor;
import bean_import.condition.TestConditionBeanConfiguration;
import bean_import.selector_registrar.CustomBeanDefinitionRegister;
import bean_import.selector_registrar.CustomImportSelector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// TODO. Spring Context配置器: 三种@Import引入Bean的方式
@Configuration
@Import(value = {
        TestConditionBeanConfiguration.class,
        CustomImportSelector.class,
        CustomBeanDefinitionRegister.class})
public class SpringBeansConfiguration {

    // TODO. 通过参数自动注入Bean, 如果存在多个Bean对象则使用Qualifier来区分
    @Bean
    public MyBeanCtor myBeanCtor(@Qualifier("myBean") MyBean myBean) {
        myBean.print("myBean");
        System.out.println("Auto Inject @Bean");
        return new MyBeanCtor("name");
    }

    // TODO. 根据Bean名称来区分同类型的Bean
    @Bean(name = "old-bean")
    public MyBean myBean1() {
        return new MyBean();
    }

    @Bean(name = "new-bean")
    public MyBean myBean2() {
        return new MyBean();
    }
}
