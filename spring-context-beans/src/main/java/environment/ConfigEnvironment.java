package environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "properties.environment")
public class ConfigEnvironment {

    private Environment environment;

    @Autowired
    public void showEnvironmentProperties(Environment environment) {
        System.out.println("env key1==" + environment.getProperty("key1"));
    }
}
