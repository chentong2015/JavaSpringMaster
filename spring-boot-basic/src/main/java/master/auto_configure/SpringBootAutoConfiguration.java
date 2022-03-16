package master.auto_configure;

// 1. Spring boot 如何实现自动装配 ?
//    1.1 @EnableAutoConfiguration通过@Import导入bean定义，使用ImportSelector批量导入
//    1.2 通过SPI机制读取\META-INF\spring.factories文件中配置类, 批量加载bean定义，自动解析
// 2. 装配的对象是什么? Bean Definition
public class SpringBootAutoConfiguration {

    // 自动装配DispatcherServlet的类型 ??
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
