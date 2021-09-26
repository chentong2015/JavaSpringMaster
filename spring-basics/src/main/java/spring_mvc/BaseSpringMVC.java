package spring_mvc;

import spring_mvc.spi.model.IParseDoc;

import java.util.ServiceLoader;

// Spring Web如何整合Spring MVC(原始使用.xml配置文件)
// Spring Web源码分析
public class BaseSpringMVC {

    // Spring MVC中父子容器: TODO: 子容器可以应引用父容器的对象，目的是为了"指责单一"
    // Servlet WebApplicationContext 子容器 => C,View,Handler
    // 1. ContextLoaderListener: spring-mvc.xml 子配置: controller
    //
    // Root WebApplicationContext    父容器 => IoC容器,services, repositories
    // 1. DispatcherServlet: spring.xml 父配置: 数据源，dao，service
    //

    // 不使用web.xml来完成以上配置，基于Servlet3.0规范

    // TODO: 如何往容器中注入Web三大组件(servlet, listener, filter)
    // 1. 配置web.xml
    // 2. @WebServlet("/HomeServlet")
    //    @WebListener
    //    @WebFilter(value="/hello")
    // 3. SPI机制: 通过ServiceLoader来加载配置  ===> Spring-web module源码的实现方式
    //    3.1 在/resources classpath路径下面配置指定的文件名称，使用接口的全路径
    //    3.2 在文件中配置使用的具体配置类型的全路径
    //    3.3 要求配置的类型必须有无参的构造器
    public void testSPI() {
        // TODO: 通过ServiceLoader类读取前面配置的文件，将配置的类型通过反射创建对象
        // 彻底解耦的实现，只需要改配置文件
        ServiceLoader<IParseDoc> iParseDocs = ServiceLoader.load(IParseDoc.class);
        for (IParseDoc iParseDoc : iParseDocs) {
            iParseDoc.parse();
        }
    }
}
