package master.auto_configure.config;

import master.auto_configure.service.AutoConfigService;
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
