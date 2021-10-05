package bean.bean_lifecycle;

// 1. Bean是什么?
//    beanName(key) -> Bean对(value)
//    被Spring管理的对象(A simple java Object)叫做bean
// 2. Singleton Bean如何理解 ?
//    单例bean和单例模式(类型只能创建一个对象)没有关系
//    可能有多个bean名称对应同类型的bean，所谓的单例是指同一个bean名称，对应的是同一个对象
public class BaseBeanLifecycle {

    // Bean的创建过程: UserService component = context.getBean("UserService", MyBean.class);
    // UserService类
    // --> 基于构造器反射 推断构造方法 ?
    // --> 原始对象      内部属性为null
    // --> 依赖注入      填充属性，设置添加了@Autowired注解的属性         => populateBean()
    // --> 初始化前      调用添加了@PostConstruct注解的方法, 自定义的逻辑
    // --> 初始化        执行InitializingBean接口的方法                => initializeBean()
    // --> 初始化后      进行AOP
    //                  ---> 代理对象(@Autowired的属性为null)
    // --> bean(属性有值)
    // 如果有AOP，则将代理对象放置到Spring容器中，之后从其中取值
}
