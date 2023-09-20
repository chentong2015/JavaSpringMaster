package context;

import aop_aspect.AspectConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class SpringContextEnvironment {

    // 从Spring Application启动的环境变量中获取指定的变量值
    // demo.project.name=chentong;demo.project.coder=ctong
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AspectConfiguration.class);
        Environment environment = context.getEnvironment();
        String name = environment.getProperty("demo.project.name", "default name");
        String coder = environment.getProperty("demo.project.coder", "coder");
        System.out.println(name);
        System.out.println(coder);
    }
}
