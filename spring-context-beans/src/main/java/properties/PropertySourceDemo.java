package properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class PropertySourceDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(PropertySourceConfig.class);
        Environment environment = context.getEnvironment();

        // 从application.properties以及@PropertySource注解引入的配置文件中读取属性
        System.out.println(environment.getProperty("key1"));
    }
}