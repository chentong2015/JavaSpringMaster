package profile;

import org.springframework.context.annotation.*;


// 当profile设置成dev时才会注入bean
@Profile("dev")
@Configuration
@ComponentScan(basePackages = "profile")
public class ProfileConfig {

    @Bean(name = "bean-model")
    public BeanModel beanModel() {
        return new BeanModel();
    }

    // 缩小Profile的约束范围
    @Bean
    @Profile("test")
    public BeanModel2 beanModel2() {
        return new BeanModel2();
    }


    class BeanModel {
        public void printBaseModel() {
            System.out.println("Print bean model");
        }
    }

    class BeanModel2 {
        public void printBaseModel() {
            System.out.println("Print bean model");
        }
    }
}
