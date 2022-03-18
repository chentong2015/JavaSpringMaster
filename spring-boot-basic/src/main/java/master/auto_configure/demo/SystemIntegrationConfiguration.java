package master.auto_configure.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemIntegrationConfiguration {

    // 在Configuration配置声明bean
    @Bean
    @ConditionalOnMissingBean
    AutoConfigService autoConfigService() {
        return new AutoConfigService();
    }
}
