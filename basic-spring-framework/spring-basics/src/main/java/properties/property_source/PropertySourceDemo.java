package properties.property_source;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class PropertySourceDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
        Environment environment = context.getEnvironment();

        // 从@PropertySource属性引入的配置文件中读取属性
        // Found key 'key1' in PropertySource 'class path resource [application.properties]' with value of type String
        System.out.println(environment.getProperty("key1"));
    }
}
