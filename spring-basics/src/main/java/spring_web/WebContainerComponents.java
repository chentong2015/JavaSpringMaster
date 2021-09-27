package spring_web;

import spring_web.spi.IParseDoc;

import java.util.ServiceLoader;

// TODO: 如何往容器中注入Web三大组件(servlet, listener, filter)
// 1. 配置xml文件
//    web.xml;
//    dispatcher-servlet.xml
// 2. 使用特定的注解
//    @WebServlet("/HomeServlet");
//    @WebListener;
//    @WebFilter(value="/hello")
// 3. SPI机制: 基于Servlet3.0规范//
//    3.1 在/resources classpath路径下面配置指定的文件名称，使用接口的全路径
//    3.2 在文件中配置使用的具体配置类型的全路径
//    3.3 要求配置的类型必须有无参的构造器
public class WebContainerComponents {

    // TODO: 通过ServiceLoader类读取前面配置的文件，将配置的类型通过反射创建对象
    public void testSPI() {
        // 彻底解耦的实现，只需要改配置文件
        ServiceLoader<IParseDoc> iParseDocs = ServiceLoader.load(IParseDoc.class);
        for (IParseDoc iParseDoc : iParseDocs) {
            iParseDoc.parse();
        }
    }

    // TODO: Spring如何整合Spring MVC以及启动流程
    // 配置文件名称：javax.servlet.ServletContainerInitializer
    // org.springframework.web.SpringServletContainerInitializer
    //
    // @HandlesTypes(WebApplicationInitializer.class)
    // public class SpringServletContainerInitializer implements ServletContainerInitializer {
    //   TODO: 该方法在tomcat.startup启动时自动调用
    //         Set<Class<?>>集合包含了所有实现注解标注的接口(WebApplicationInitializer)的类型
    //         ServletContext Web应用的上下文
    //   public void onStartup(@Nullable Set<Class<?>> webAppInitializerClasses, ServletContext servletContext)
    //			throws ServletException {
    //		List<WebApplicationInitializer> initializers = Collections.emptyList();
    //		if (webAppInitializerClasses != null) {
    //			initializers = new ArrayList<>(webAppInitializerClasses.size());
    //			for (Class<?> waiClass : webAppInitializerClasses) {
    //				// Be defensive: Some servlet containers provide us with invalid classes, no matter what @HandlesTypes says...
    //				if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers())
    //				&& WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
    //					try {
    //						initializers.add((WebApplicationInitializer)
    //						ReflectionUtils.accessibleConstructor(waiClass).newInstance());
    //					} catch (Throwable ex) {
    //						throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
    //					}
    //				}
    //			}
    //		}
    //		if (initializers.isEmpty()) {
    //			servletContext.log("No Spring WebApplicationInitializer types detected on classpath");
    //			return;
    //		}
    //		servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
    //		// TODO: 排序，如果有多个实现WebApplicationInitializer接口的类型，需要判断执行的优先顺序
    //		AnnotationAwareOrderComparator.sort(initializers);
    //		for (WebApplicationInitializer initializer : initializers) {
    //          // TODO: 调用到自定义的WebApplicationInitializer实现类型的onStartup()方法;
    //          //       WebAppInitializer中配置web的三大组件，等效于xml的配置
    //			initializer.onStartup(servletContext);
    //		}
    //   }
    // }
}
