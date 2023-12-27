package annotation.config;

import annotation.bean.MyBeanImpl;
import annotation.bean.MyBeanInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 主配置类，等效于beans.xml
@ComponentScan(basePackages = "spring_ioc") // 通过扫描component来注入bean
public class SpringAppConfig {

    // 注入的bean的方法id就是方法的名称(大小写严格一致)
    // 配置bean在销毁时，callback回调的方法(class中申明的方法)
    @Bean(destroyMethod = "shutdown")
    public MyBeanInstance myBeanInstance() {
        return new MyBeanInstance();
    }

    @Bean
    // @ConditionalOnMissingBean spring-boot中自动装配，bean的条件声明
    public MyBeanImpl myBeanImpl() {
        return new MyBeanImpl();
    }
}
