package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvironmentConfig {

    private Environment environment;

    // 1. 获取Spring framework context环境中的属性值
    // 2. System.setProperty("key", "chen test"); 通过设置系统属性值来定义
    @Autowired
    public void EnvironmentConfig(Environment environment) {
        System.out.println(environment.getProperty("key"));
        System.out.println(System.getProperty("key"));
        System.out.println(System.getProperty("key2"));
    }
}
