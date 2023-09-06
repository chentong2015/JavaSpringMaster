package bean.bean_lifecycle;

//
public class BaseBeanLifecycle {

    // Bean的创建过程:
    // UserService main.controller = context.getBean("UserService", MyBean.class);
    // UserService类
    // --> 基于构造器反射 推断构造方法 ?
    // --> 原始对象      内部属性为null
    // --> 依赖注入      填充属性, 属性赋值 populateBean()
    //                  设置添加了@Autowired注解的属性
    // --> 初始化前      调用添加了@PostConstruct注解的方法, 自定义的逻辑
    // --> 初始化        执行InitializingBean接口的方法 initializeBean()
    // --> 初始化后      进行AOP
    //                  ---> 代理对象(@Autowired的属性为null)
    // --> spring_framework.bean(属性有值)
    // 如果有AOP，则将代理对象放置到Spring容器中，之后从其中取代理对象

    // class -> BeanDefinition -> 对象 -> 属性赋值 -> init(before, after) -> aware -> bean -> applicationContext
}
