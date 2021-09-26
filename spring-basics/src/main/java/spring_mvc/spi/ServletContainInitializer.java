package spring_mvc.spi;

// @HandlesTypes(value = {IParseDoc.class})
public class ServletContainInitializer { // implements ServletContainerInitializer

    // 1. Set<Class<?>> 集合包含了所有实现注解标注的接口的类型
    // 2. 在tomcat.startup 启动的时候，会自动调用该方法
    // public void onStartup(Set<Class<?>> set, ServletContext servletContext) {
    //     servletContext.addListener(AngleListener);
    //     TODO: 在容器中注册web的三大组件
    //     ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("angleServlet", new AngleServlet());
    //     FilterRegistration.Dynamic angleFilter = servletContext.addFilter("angleFilter", AngleFilter.class);
    //     angleFilter.addMappingForUrlPatterns(EnumSet.of(Dispatcher.REQUEST), true, "/*"):
    // }
}
