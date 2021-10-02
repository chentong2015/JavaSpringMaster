package spring_web.web_app_initializer;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

// 根据WebApplicationInitializer的继承链，选择实现合适的抽象类或者接口
public class MyWebAppInitializerNew extends AbstractDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 1. 创建根容器(此时是空的)
        // 2. new ContextLoaderListener
        // 3. 将根配置保存到根容器中
        // 4. 将ContextLoaderListener注册到servletContext
        super.onStartup(servletContext);
        // 1. 创建子容器(此时是空的) ServletApplicationContext
        // 2. 创建DispatcherServlet
        registerDispatcherServlet(servletContext);
    }

    // ContextLoaderListener(Listener)的特点: 在启动的时候会调用初始化方法
    // 	@Override
    //	public void contextInitialized(ServletContextEvent event) {
    //		initWebApplicationContext(event.getServletContext());
    //	}
    //
    // ContextLoader.initWebApplicationContext() {
    //    // 如果是通过xml配置来的，则调用无参构造器
    //	  if (this.context == null) {
    //	  	this.context = createWebApplicationContext(servletContext);
    //	  }
    //	  // 反之，调用含参构造器
    //	  if (this.context instanceof ConfigurableWebApplicationContext) {
    //	  	ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) this.context;
    //	  	// TODO: 判断父容器有没有被激活，是否调用容器的.refresh()方法
    //	  	if (!cwac.isActive()) {
    //	  		// The context has not yet been refreshed -> provide services such as
    //	  		// setting the parent context, setting the application context id, etc
    //	  		// 父容器是没有父容器的
    //	  		if (cwac.getParent() == null) {
    //	  			// The context instance was injected without an explicit parent ->
    //	  			// determine parent for root web application context, if any.
    //	  			ApplicationContext parent = loadParentContext(servletContext);
    //	  			cwac.setParent(parent);
    //	  		}
    //	  		configureAndRefreshWebApplicationContext(cwac, servletContext);
    //	  	}
    //	  }
    // }
    //
    //  configureAndRefreshWebApplicationContext() {
    //    调用方法为父(子)容器加载组件，填充service dao对象，确定容器中不为空
    //    wac.refresh();
    //  }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
