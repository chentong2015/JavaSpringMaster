package main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class EnvironmentConfig {

    private String name;

    @Autowired
    private Environment environment;

    // 直接获取environment.properties配置文件中的内容
    public void getNameFromProperties() {
        name = environment.getProperty("env-name");
    }
}
