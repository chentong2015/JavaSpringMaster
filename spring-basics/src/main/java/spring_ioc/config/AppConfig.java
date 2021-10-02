package spring_ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_aop.aspect_base.AspectFastCalculation;
import spring_aop.aspect_base.model.FastCalculation;

// Spring 2.5 .xml --> Spring 3.0 Java注解 --> Spring 5.0 --> Spring Boot Java注解
// 从spring3.0版本之后，推荐使用注解的方式
@Configuration // 主配置类，等效于beans.xml
@EnableAspectJAutoProxy // 开启AOP
@ComponentScan(basePackages = "spring_ioc.base") // 通过扫描component来注入bean
public class AppConfig {

    // 注入的bean的方法id就是方法的名称(大小写严格一致)
    @Bean
    public FastCalculation fastCalculation() {
        return new FastCalculation();
    }

    @Bean
    public AspectFastCalculation aspectCalculation() {
        return new AspectFastCalculation();
    }
}
