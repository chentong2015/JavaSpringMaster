package spring_circular_dependency;

// TODO: Spring使用"三级缓存"来解决"循环依赖"的问题  ==> 扩展到死锁，相互依赖问题的解决
// 1. 单例池 ConcurrentHashMap: singletonObjects
// 2. 二级缓存 HashMap: earlySingletonObjects
// 3. HashMap
public class SpringCircularDependency {

    // 从Bean的生命周期分析Spring中的循环依赖问题:
    // AService类 --> 实例化 --> AService对象(原始对象) --> 填充属性和初始化 --> AOP --> Bean 放到单例池(缓存)
    //      在@Autowired注入时，从单例池中找，如果没有则去创建BService bean
    //      BService类 --> 实例化 --> BService对象(原始对象) --> 填充属性和初始化 --> AOP --> Bean 放到单例池(缓存)
    //          在创建BService的过程中，需要重单例池中找AService的bean

    // 二级缓存的基础逻辑:
    // A a = new A();
    // B b = new B();
    // b.a = a;   这里的a对象虽然不"完整", 但是经过下一步之后a对象会变成完整的
    // a.b = b;   最终创建出来的对象的属性都是有值的 !!

    // 如何判断AService出现了循环依赖? 以至于需要提前AOP
    // creatingSet<'aService'> 表示正在创建的bean
    // 如果在其他的bean的创建过程中，使用到了这个正在创建的bean(在set中)，那么就是一种循环依赖，则提前AOP
    // creatingSet.remove('aService')

    // TODO: 为什么二级缓存可以解决，Spring要使用三级缓存 ?
    //
    //
}
