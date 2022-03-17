package master.auto_configure;

// Spring boot Auto Configuration 自动装配
// Version 1: .xml配置
// Version 2: Java配置版本(使用注解)
// Version 3: 使用@Import导入配置类(@Configuration，包含多个bean定义) ==> hard code硬编码

// 1. 如何实现自动装配 ?
//    1.1 @EnableAutoConfiguration通过@Import导入bean定义，使用ImportSelector批量导入
//    1.2 通过SPI机制读取\META-INF\spring.factories文件中配置类, 批量加载bean定义，自动解析
// 2. 装配的对象是什么? Bean Definition
public class SpringBootAutoConfiguration {

    // DispatcherServlet的自动装配 ?
    // org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration
    // @Bean(name = {"dispatcherServlet"})
    // public DispatcherServlet dispatcherServlet(WebMvcProperties webMvcProperties) {
    //     DispatcherServlet dispatcherServlet = new DispatcherServlet();
    //     dispatcherServlet.setDispatchOptionsRequest(webMvcProperties.isDispatchOptionsRequest());
    //     dispatcherServlet.setDispatchTraceRequest(webMvcProperties.isDispatchTraceRequest());
    //     dispatcherServlet.setThrowExceptionIfNoHandlerFound(webMvcProperties.isThrowExceptionIfNoHandlerFound());
    //     dispatcherServlet.setPublishEvents(webMvcProperties.isPublishRequestHandledEvents());
    //     dispatcherServlet.setEnableLoggingRequestDetails(webMvcProperties.isLogRequestDetails());
    //     return dispatcherServlet;
    // }
}
