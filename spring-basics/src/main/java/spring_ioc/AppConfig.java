package spring_ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// Spring 2.5 .xml --> Spring 3.0 Java注解 --> Spring 5.0 --> Spring Boot Java注解
// 从spring3.0版本之后，推荐使用注解的方式
@Configuration // 主配置类，等效于beans.xml
@EnableAspectJAutoProxy // 开启AOP
@ComponentScan(basePackages = "spring_ioc") // 通过扫描component来注入bean
public class AppConfig {

    // 注入的bean的方法id就是方法的名称(大小写严格一致)
    // 配置bean在销毁时，callback回调的方法(class中申明的方法)
    @Bean(destroyMethod = "shutdown")
    public MyBeanInstance myBeanInstance() {
        return new MyBeanInstance();
    }
}
