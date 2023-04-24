package masterbeans;

//Beans Scope 5种作用域 
// 1. singleton(Default): Scopes a single bean definition to a single object instance per Spring IoC container.

// 2. prototype 原型: Scopes a single bean definition to any number of object instances 不限bean的实例对象数目 

// ## 以下两个作用需要使用在Web Application上 ##
// 3. request: Scopes a single bean definition to the lifecycle of a single HTTP request 限制单个HTTP请求的生命周期 
//            each HTTP request has its own instance of a bean created off the back of a single bean definition. 
//            Only valid in the context of a web-aware Spring ApplicationContext. 

// 4. session: Scopes a single bean definition to the lifecycle of an HTTP Session. 限制单个HTTP Session的生命周期 
//           "User session contains infos about usr across multiple HTTP Requests
//            当用户第一次访问(登录)请求时, 生成用户的唯一session id, 该session id通常是存储在cookie或者是request parameter中"
//            Only valid in the context of a web-aware Spring ApplicationContext. 

// 5. global session: Scopes a single bean definition to the lifecycle of a global HTTP Session
//            Typically only valid when used in a portlet context
//            Only valid in the context of a web-aware Spring ApplicationContext.
public class BeanScopes {

    public void testBeanScope() {
        System.out.println("test bean scope");
    }
}
