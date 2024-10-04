package properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class PropertySourceDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
        Environment environment = context.getEnvironment();

        // 从@PropertySource属性引入的配置文件中读取属性
        // Get 'key1' value from PropertySource [application.properties]
        System.out.println(environment.getProperty("key1"));
    }
}
