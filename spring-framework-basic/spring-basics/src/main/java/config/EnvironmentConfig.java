package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {

    private Environment environment;

    // 从系统环境中获取属性的配置，或者设置属性
    @Autowired
    public EnvironmentConfig(Environment environment) {
        String value = environment.getProperty("env-name");
        System.setProperty("property_name", "false");
    }
}
