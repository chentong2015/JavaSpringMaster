package spring_customize;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev") // 配置该类型只会在"dev" profile中出现，在production中不会出现
public class BaseProfileConfig {
    
}
