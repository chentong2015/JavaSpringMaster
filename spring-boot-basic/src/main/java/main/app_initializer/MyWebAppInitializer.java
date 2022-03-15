package main.app_initializer;

import base.swagger.ui.SpringBootConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringBootConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));

        // TODO: 将Web应用的上下文添加到IoC的上下文 => 把Tomcat容器加到IoC容器中
        // 针对Json Converter的设置
        // rootContext.setServletContext(container);
        // rootContext.refresh();

        AnnotationConfigWebApplicationContext childContext = new AnnotationConfigWebApplicationContext();
        // dispatcherContext.register(DispatcherConfig.class);
        // Register and map the dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(childContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
