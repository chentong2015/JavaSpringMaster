package properties.environment;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class EnvironmentPropertyDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConfigEnvironment.class);
        Environment environment = context.getEnvironment();

        String name = environment.getProperty("name", "default");
        String coder = environment.getProperty("coder", "coder");
        System.out.println(name);
        System.out.println(coder);
    }
}
