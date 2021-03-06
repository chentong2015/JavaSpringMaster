package master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// Spring Boot: 构建在Spring MVC的上层，提供高效开发
// 1. 不需Spring MVC原始web.xml配置, 使用注解+SPI机制(servlet3.0规范)
// 2. 去掉外部的tomcat启动起来, 使用内嵌的tomcat包
@SpringBootApplication(excludeName = {}) // 可以移除掉指定的名称
@EnableCaching
public class MasterSpringBoot { // 该启动类型不能放置在default package

    // Spring Boot + tomcat
    // 1. 先创建Spring容器
    // 2. 再启动tomcat
    public static void main(String[] args) {
        SpringApplication.run(MasterSpringBoot.class, args);
    }

    // TODO: 使用Spring Boot时不推荐使用注解@EnableWebMvc ==> 导致功能缺失
    // @EnableWebMvc的作用会导致引入WebMvcConfigurationSupport类型(spring_framework.bean)
    // 以至于无法使用WebMvcAutoConfiguration的功能
    //    @Import({DelegatingWebMvcConfiguration.class})
    //    DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport

    // TODO: Spring boot自动装配类型WebMvcAutoConfiguration ==> Spring boot为Spring MVC提供的功能
    //       仅在容器中没有WebMvcConfigurationSupport.class bean时起作用
    // @Configuration(proxyBeanMethods = false)
    // @ConditionalOnWebApplication(type = Type.SERVLET)
    // @ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
    // @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
    // @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
    // @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
    //   ValidationAutoConfiguration.class })
    // public class WebMvcAutoConfiguration {
    //    访问静态资源文件
    // }

    // 3. 在tomcat启动完成之后，自动运行指定逻辑
    //    CommandLineRunnerConfig实现接口ApplicationRunner, 使用args参数
    //    注入CommandLineRunnerConfig, run()方法将会被自动调用
}
