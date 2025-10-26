package profile;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProfileConfig.class);
        System.out.println(context.containsBean("bean-model"));
    }
}
