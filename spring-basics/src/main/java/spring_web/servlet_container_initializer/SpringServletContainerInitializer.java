package spring_web.servlet_container_initializer;

// TODO: Spring如何整合Spring MVC以及启动流程
public class SpringServletContainerInitializer {

    // 1. 配置文件名称
    // resources/META-INF/services/javax.servlet.ServletContainerInitializer
    // org.springframework.web.SpringServletContainerInitializer 找到启动时需要调用的类型的onStartup()方法
    //
    // 2. 定义Servlet容器启动器
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
