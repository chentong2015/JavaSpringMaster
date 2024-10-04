package profile;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class ProfilePropertyDemo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ConfigProfile.class);
        // 检查应用设置的profile配置
        Environment environment = context.getEnvironment();
        for (String profile: environment.getActiveProfiles()) {
            System.out.println(profile);
        }
        // 检查注入的bean
        if (context.containsBean("bean-model")) {
            BeanModel beanModel = (BeanModel) context.getBean("bean-model");
            beanModel.printBaseModel();
        }
    }
}
