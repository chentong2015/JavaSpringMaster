package spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot实现的两个效果
// 1. 不需要配置Spring MVC的原始web.xml文件
//    1.1 直接通过注解, servlet3.0规范
//    1.2 通过SPIji机制来实现
// 2. 去掉外部的tomcat启动起来
//    2.1 使用内嵌的tomcat包
@SpringBootApplication
public class BaseSpringBoot { // 该启动类型不能放置在default package

    public static void main(String[] args) {
        SpringApplication.run(BaseSpringBoot.class, args);
    }

    // TODO: 使用Spring Boot时不推荐使用注解@EnableWebMvc ==> 导致功能缺失
    // @EnableWebMvc的作用会导致引入WebMvcConfigurationSupport类型(bean)
    // 以至于无法使用WebMvcAutoConfiguration的功能
    // @Import({DelegatingWebMvcConfiguration.class})
    // DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport

    // TODO: Spring boot自动装配类型WebMvcAutoConfiguration ==> Spring boot为Spring MVC提供的功能
    //  仅在容器中没有WebMvcConfigurationSupport.class bean时起作用
    // @Configuration(proxyBeanMethods = false)
    // @ConditionalOnWebApplication(type = Type.SERVLET)
    // @ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
    // @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
    // @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
    // @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class, ValidationAutoConfiguration.class })
    // public class WebMvcAutoConfiguration {
    //    访问静态资源文件
    // }
}
