package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_aop.aspect_base.AspectFastCalculation;
import spring_aop.aspect_base.FastCalculation;

@Configuration // 主配置类，等效于beans.xml
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "spring_ioc.model") // 通过扫描component来注入bean
public class AppConfig {

    @Bean
    public FastCalculation fastCalculation() {
        return new FastCalculation();
    }

    @Bean
    public AspectFastCalculation aspectCalculation() {
        return new AspectFastCalculation();
    }
}
