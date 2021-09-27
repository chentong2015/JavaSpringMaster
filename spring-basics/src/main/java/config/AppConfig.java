package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring_aop.aspect_base.AspectFastCalculation;
import spring_aop.aspect_base.model.FastCalculation;

// TODO: 从spring3.0版本之后，推荐使用注解的方式
@Configuration // 主配置类，等效于beans.xml
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "spring_ioc.base") // 通过扫描component来注入bean
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
