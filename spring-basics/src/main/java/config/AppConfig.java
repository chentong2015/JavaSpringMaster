package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_aop.demo.AspectCalculation;
import spring_aop.demo.FastCalculation;

@Configuration // 主配置类，等效于beans.xml
@EnableAspectJAutoProxy // 使用注解来实现AOP的功能
@ComponentScan(basePackages = "spring_ioc.model") // 通过扫描component来注入bean
public class AppConfig {

    @Bean
    public FastCalculation fastCalculation() {
        return new FastCalculation();
    }

    @Bean
    public AspectCalculation aspectCalculation() {
        return new AspectCalculation();
    }
}
