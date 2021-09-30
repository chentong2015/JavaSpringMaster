package spring_web.servlet_container_initializer;

// TODO: 自定义ServletContainerInitializer
// @HandlesTypes(value = {IParseDoc.class})
public class MyServletContainerInitializer { // implements ServletContainerInitializer

    // 在容器中注册web的三大组件
    // public void onStartup(Set<Class<?>> set, ServletContext servletContext) {
    //     servletContext.addListener(AngleListener);
    //     ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("angleServlet", new AngleServlet());
    //     servletRegistration.addMapping("/angleServlet");
    //     FilterRegistration.Dynamic angleFilter = servletContext.addFilter("angleFilter", AngleFilter.class);
    //     angleFilter.addMappingForUrlPatterns(EnumSet.of(Dispatcher.REQUEST), true, "/*"):
    // }
}
