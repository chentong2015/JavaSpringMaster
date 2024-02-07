package properties.profile;

import org.springframework.context.annotation.*;

// TODO. 运行时指定使用的profile配置 -Dspring.profiles.active=dev
// application-{profile}.properties
// application-dev.properties
// application-prod.properties
@Configuration
@ComponentScan(basePackages = "properties.profile")
@Profile("dev")
public class ConfigProfile {

    // 只有当profile设置成dev时才会注入指定的bean
    @Bean(name = "bean-model")
    public BeanModel beanModel() {
        return new BeanModel();
    }
}
