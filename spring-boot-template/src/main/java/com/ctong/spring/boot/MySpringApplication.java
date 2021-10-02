package com.ctong.spring.boot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MySpringApplication {

    // Spring Boot + Tomcat 默认启动顺序
    // java.lang.NoClassDefFoundError: javax/servlet/ServletRequest
    public static AnnotationConfigWebApplicationContext run(Class config) {
        // 1. 先创建Spring容器
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(config);
        // appContext.refresh(); // 激活容器，为容器加载组件，然后填充指定bean
        // 2. 启动Tomcat
        startTomcat(appContext);
        return appContext;
    }

    private static void startTomcat(AnnotationConfigWebApplicationContext appContext) {
        Tomcat tomcat = new Tomcat();
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

        // DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        // tomcat.addServlet(contextPath, "dispatcher", dispatcherServlet);
        // context.addServletMappingDecoded("/*", "dispatcher");
        try {
            //  Cannot invoke "String.equals(Object)" because "newHost.name" is null
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }
    }
}
