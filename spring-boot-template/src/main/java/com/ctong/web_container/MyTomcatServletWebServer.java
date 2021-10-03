package com.ctong.web_container;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MyTomcatServletWebServer {

    // 自定义tomcat启动方法，设置接受请求的路径和端口
    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        try {
            tomcat.addWebapp("/", "D:\\");
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            ex.printStackTrace();
        }
    }

    // TomcatServletWebServerFactory类型源码
    // Spring Boot内嵌tomcat的启动和配置
    // @Override
    //	public WebServer getWebServer(ServletContextInitializer... initializers) {
    //		if (this.disableMBeanRegistry) {
    //			Registry.disableRegistry();
    //		}
    //		Tomcat tomcat = new Tomcat();
    //		File baseDir = (this.baseDirectory != null) ? this.baseDirectory : createTempDir("tomcat");
    //		tomcat.setBaseDir(baseDir.getAbsolutePath());
    //		Connector connector = new Connector(this.protocol);
    //		connector.setThrowOnFailure(true);
    //		tomcat.getService().addConnector(connector);
    //		customizeConnector(connector);
    //		tomcat.setConnector(connector);
    //		tomcat.getHost().setAutoDeploy(false);
    //		configureEngine(tomcat.getEngine());
    //		for (Connector additionalConnector : this.additionalTomcatConnectors) {
    //			tomcat.getService().addConnector(additionalConnector);
    //		}
    //		prepareContext(tomcat.getHost(), initializers);
    //		return getTomcatWebServer(tomcat);
    //	}
    //
    //  WebServer getTomcatWebServer(tomcat) {
    //     ...
    //     最终会调用的两个方法
    //     tomcat.start();
    //     tomcat.getServer().await()
    // }
}
