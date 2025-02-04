package profile;

import org.springframework.context.annotation.*;

// TODO. -Dspring.profiles.active=dev 运行时profile配置
// application-{profile}.properties
// application-dev.properties
// application-prod.properties

@Profile("dev")
@Configuration
@ComponentScan(basePackages = "properties.profile")
public class ProfileConfiguration {

    // 当profile设置成dev时才会注入bean
    @Bean(name = "bean-model")
    public BeanModel beanModel() {
        return new BeanModel();
    }

    // 缩小profile的设置范围
    @Bean
    @Profile("test")
    public BeanModel2 beanModel2() {
        return new BeanModel2();
    }
}
