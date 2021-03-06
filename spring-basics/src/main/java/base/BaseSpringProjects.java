package base;

/**
 * TODO: Spring projects https://spring.io/projects/
 * 1. Spring解决了J2EE中出现的比较大的问题：Enterprise Java Bean Model (EJB)
 * 2. Spring提供和构建了infrastructure, 开发者可以专注在业务层面, 不需要关注JEE更底层的逻辑
 * 3. Spring是轻量级的，很容易使用轻量级的Web Server, 可以只选择需要的module模块
 * 3. Spring提倡使用POJO: Plain Old Java Object
 */
public class BaseSpringProjects {

    //                  运行时: 架构和所包含的Modules模块
    //                  <<Spring Framework Runtime>>
    //   Data Access/Integration                  Web
    //       JDBC / ORM
    //       OXM / JMS               WebSocket         Servlet
    //      Transactions             Web               Portiet
    // <   AOP / Aspects             Instrumentation   Messaging   >
    // <                     Core Container                     >
    //      Beans       Core             Context        SpEL
    //                          Test

    // OXM: Object XML mapping implementation => JAXB (Java Architecture for XML Binding), Castor
    // JMS: Java messaging com.ctong.springboot.service

    // AOP: 提供Spring对面向方面(横切面)编程的实现, enables teh modularization of concerns, logging, security
    // Aspects: separate module that provides integration with AspectJ
    // Instrumentation 仪器仪表: provide class loader implementations
    // Messaging: provide the foundation for messaging

    // Beans & Core 提供基础的框架 IoC/DI: Design pattern 对象的创建责任被转移到对象工厂中，将紧耦合改成松耦合(依赖接口或者抽象类)
    // Context: 提供对container中beans对象的访问(获取)
    // SpEL (Spring language expression): Spring的特殊表达式语言, 用于查询和操作objects
}
