package com.ctong.spring.boot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplicationStarter {

    // 1. 先创建Spring容器
    // 2. 再创建Web Server
    public static AnnotationConfigWebApplicationContext run(Class config) {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(config);
        // appContext.refresh(); // 激活容器，为容器加载组件，然后填充指定bean
        startTomcat(appContext);
        return appContext;
    }

    private static void startTomcat(AnnotationConfigWebApplicationContext appContext) {
        Tomcat tomcat = new Tomcat();
        tomcat.getHost().setAutoDeploy(false);
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");
        Connector connector = new Connector();
        connector.setPort(8081);
        service.addConnector(connector);
        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");
        service.setContainer(engine);

        Host host = new StandardHost();
        host.setAppBase("localhost");
        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.DefaultWebXmlListener());
        host.addChild(context);
        engine.addChild(host);

        // Spring MVC中的servlet, 根据接收到的请求从自己的容器中找到特定的Controller
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        // TODO: 添加自定义配置的bean, 提高程序的扩展性
        DispatcherServlet myDispatcherServlet = appContext.getBean(DispatcherServlet.class);
        myDispatcherServlet.setApplicationContext(appContext);
        // tomcat.addServlet(contextPath, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/*", "default");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }
    }
}
