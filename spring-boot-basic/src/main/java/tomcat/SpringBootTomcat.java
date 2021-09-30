package tomcat;

public class SpringBootTomcat {

    // TomcatServletWebServerFactory类型源码
    // 内嵌tomcat的启动和配置
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
    //      TODO: 方法中调用.start(), tomcat.getServer().await();方法
    //		return getTomcatWebServer(tomcat);
    //	}
}
