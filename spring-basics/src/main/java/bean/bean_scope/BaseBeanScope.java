package bean.bean_scope;

// TODO: 注意对Singleton Scope的理解
// 始终产生的是一个新的实例对象，单列指名称和对象的一一对应 !!
// Bean scope forces Spring to produce a new bean instance as per the scope defined

// https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html
public class BaseBeanScope {

    // Beans Scope 5种作用域
    // 1. singleton(Default):
    //    Scopes a single bean definition to a single object instance per Spring IoC container
    //    The singleton scope should be used for stateless beans 无状态的

    // 2. prototype 原型:
    //    Scopes a single bean definition to any number of object instances
    //    The prototype scope for all beans that are stateful 原型是包含有状态的

    // ## 以下两个作用需要使用在Web Application上 ##
    // 3. request:
    //    Scopes a single bean definition to the lifecycle of a single HTTP request
    //    限制单个HTTP请求的生命周期
    //    each HTTP request has its own instance of a bean created off the back of a single bean definition.
    //    Only valid in the context of a web-aware Spring ApplicationContext.

    // 4. session:
    //    Scopes a single bean definition to the lifecycle of an HTTP Session.
    //    限制单个HTTP Session的生命周期
    //    "User session contains infos about usr across multiple HTTP Requests
    //    当用户第一次访问(登录)请求时, 生成用户的唯一session id,
    //    该session id通常是存储在cookie或者是request parameter中"
    //    Only valid in the context of a web-aware Spring ApplicationContext.

    // 5. global session:
    //    Scopes a single bean definition to the lifecycle of a global HTTP Session
    //    Typically only valid when used in a portlet context
    //    Only valid in the context of a web-aware Spring ApplicationContext.
}
