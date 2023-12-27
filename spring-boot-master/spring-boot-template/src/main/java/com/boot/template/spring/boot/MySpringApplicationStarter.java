package com.boot.template.spring.boot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// 1. 先创建Spring容器
// 2. 再创建Web Server
public class MySpringApplicationStarter {

    public static AnnotationConfigWebApplicationContext run(Class config) {
        AnnotationConfigWebApplicationContext appContext =
                new AnnotationConfigWebApplicationContext();
        appContext.register(config);
        // appContext.refresh(); // 激活容器，为容器加载组件，然后填充指定bean
        startTomcat(appContext);
        return appContext;
    }

    private static String hostname = "localhost";
    private static int port = 8081;

    private static void startTomcat(AnnotationConfigWebApplicationContext appContext) {
        Tomcat tomcat = new Tomcat();
        tomcat.getHost().setAutoDeploy(false);
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");
        Connector connector = new Connector();
        connector.setPort(port);
        service.addConnector(connector);

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        Host host = new StandardHost();
        host.setName(hostname);
        host.addChild(context);
        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostname);
        engine.addChild(host);
        service.setContainer(engine);

        // 创建Spring MVC中的servlet, 指定其中的Spring容器
        // DispatcherServlet会根据请求从自己容器中找到特定的Controller，完成分发
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);
        tomcat.addServlet(contextPath, "dispatcher", dispatcherServlet);

        // 在tomcat context中添加指定mapping下的DispatcherServlet
        context.addServletMappingDecoded("/", "dispatcher");

        try {
            tomcat.start();
            System.out.println("tomcat started at " + hostname + ":" + port);
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }
    }
}
