package spring_circular_dependency;

// TODO: Spring使用"三级缓存"来解决"循环依赖"的问题  ==> 扩展到死锁，相互依赖问题的解决
// 1. 单例池  singletonObjects: ConcurrentHashMap(256)
// 2. 二级缓存 earlySingletonObjects: ConcurrentHashMap(16)
// 3. 三级缓存 singletonFactories: HashMap(16)
public class SpringCircularDependency {

    // 二级缓存的基础逻辑:
    // A a = new A();
    // B b = new B();
    // b.a = a;   这里的a对象虽然不"完整", 但是经过下一步之后a对象会变成完整的
    // a.b = b;   最终创建出来的对象的属性都是有值的 !!

    // 如何判断AService出现了循环依赖? 以至于需要提前AOP
    // creatingSet<'aService'> 表示正在创建的bean
    // 如果在其他的bean的创建过程中，使用到了这个正在创建的bean(在set中)，那么就是一种循环依赖，则提前AOP
    // creatingSet.remove('aService')
}
