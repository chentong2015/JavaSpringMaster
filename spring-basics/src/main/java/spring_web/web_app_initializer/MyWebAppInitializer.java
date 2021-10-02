package spring_web.web_app_initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import spring_web.config.MyWebMvcConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

// 完全替代web.xml中的配置
public class MyWebAppInitializer implements WebApplicationInitializer {

    // TODO: 创建的父子容器的类型是一样的AnnotationConfigWebApplicationContext
    // 通过childContext.setParent(rootContext)来确定父子容器的关联
    // 子容器中有一个特定的属性来实现关系的绑定, 调用.setParent(parent)方法
    @Override
    public void onStartup(ServletContext container) {
        // 1. Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MyWebMvcConfig.class);
        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // 2. Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext childContext = new AnnotationConfigWebApplicationContext();
        // childContext.setParent(rootContext); 直接设置父子容器的关系
        // childContext.register(DispatcherConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(childContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("app", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
