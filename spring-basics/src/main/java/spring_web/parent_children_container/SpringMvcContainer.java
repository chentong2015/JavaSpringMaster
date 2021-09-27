package spring_web.parent_children_container;

public class SpringMvcContainer {

    // TODO:子容器可以应引用父容器的对象，目的是为了"指责单一"
    // Servlet WebApplicationContext 子容器 => controller
    // spring-mvc.xml 子配置文件
    //
    // Root WebApplicationContext    父容器 => data source,services, repositories
    // spring.xml 父配置文件
}
