package com.ctong.spring.boot;

public class SpringBootWebContainer {

    // TODO: Spring Boot内嵌tomcat的启动和配置
    // TomcatServletWebServerFactory类型源码
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

    // TODO: Spring Boot Jar包中支持三种Web Server
    // 项目中使用的Spring boot jar包是已经编译过了，不再重新编译，已经包含了3中WebServer的依赖
    // 在Spring Boot配置依赖时，使用<optional>true</optional>只需要通过编辑即可，不需要放到编译后的jar中
    // 在开发的过程中，只使用其中一种，即使没有添加其他的依赖(缺少类型)，也能成功运行
    // 1. @ConditionalOnClass({ Servlet.class, Tomcat.class, UpgradeProtocol.class })
    // 2. 在执行xxx.class时，不会导致类型的初始化，不会报错 !!
    //
    // 关于Spring Boot选择的port端口配置(该端口不止给一种Web Server使用)
    // AbstractConfigurationWebServerFactory.java
    // private int port=8080;

    // TODO: Spring Boot如何判断启动对应的Web Container(只能配置一个)
    // 判断classpath中具体使用拿一个tomcat.class, jetty.class, undertow.class
    // ServletWebServerApplicationContext.java
    // private void createWebServer() {
    //    ServletWebServerFactory factory = getWebServerFactory();
    //    this.webServer = factory.getWebServer(getSelfInitializer());
    // }
    //
    // protected ServletWebServerFactory getWebServerFactory() {
    //	  String[] beanNames = getBeanFactory().getBeanNamesForType(ServletWebServerFactory.class);
    //	  if (beanNames.length == 0) { 没有配置会报错 }
    //	  if (beanNames.length > 1) { 配置多个页会报错 }
    //	  return getBeanFactory().getBean(beanNames[0], ServletWebServerFactory.class);
    //	}

    // TODO: 使用@ConditionalOnClass条件注解判断Spring容器中有什么bean ?
    // ServletWebServerFactoryConfiguration.java
    // @Configuration(proxyBeanMethods = false)
    // class ServletWebServerFactoryConfiguration {
    //	 @Configuration(proxyBeanMethods = false)
    //   表示并不是任何时候都存在这bean，只有当3个类型够存储classpath中都存在时才确定 !!
    //	 @ConditionalOnClass({ Servlet.class, Tomcat.class, UpgradeProtocol.class })
    //	 @ConditionalOnMissingBean(value = ServletWebServerFactory.class, search = SearchStrategy.CURRENT)
    //	 static class EmbeddedTomcat {
    //	 	@Bean
    //	 	TomcatServletWebServerFactory tomcatServletWebServerFactory(...) {
    //	 		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
    //          ...
    // 	 		return factory;
    //	 	}
    //	 }
}
