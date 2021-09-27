package spring_web.parent_children_container;

public class SpringMvcContainer {

    // TODO:子容器可以应引用父容器的对象，目的是为了"指责单一"
    // Servlet WebApplicationContext 子容器
    // ContextLoaderListener: spring-mvc.xml 子配置: controller
    //
    // Root WebApplicationContext    父容器 => IoC容器,services, repositories
    // DispatcherServlet: spring.xml 父配置: 数据源，dao，service
}
