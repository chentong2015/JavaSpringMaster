package profile;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class ProfilePropertyDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(ProfileConfiguration.class);

        // 检测是否注入了指定过的Bean对象
        System.out.println(context.containsBean("bean-model"));
    }
}
