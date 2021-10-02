package bean.bean_lifecycle;

// TODO: Spring Bean完整的生命周期
// 1. bean定义(的解析)
// -> BeanFactoryPostProcessor 该组件可以修改bean的定义
// 2. getBean()获取bean，生成bean
// -> BeanPostProcessor 该组件用于生成bean的属性(bean已经生成了)
// 3. bean实例化完成，放到单例缓存池中
public class BaseBeanLifecycle {

    // Bean: A simple java Object 被Spring管理的对象叫做bean
    //       beanName(key) -> Bean对(value)
    // 单例bean:
    // TODO: 和单例模式(类型只能创建一个对象)没有关系
    //       可能有多个bean名称对应同类型的bean，所谓的单例是指同一个bean名称，对应的是同一个对象

    // 1. Bean的创建:
    // UserService service = context.getBean("UserService", MyBean.class);
    // UserService类
    // --> 基于构造器反射 推断构造方法 ?
    // --> 原始对象      内部属性为null
    // --> 依赖注入      设置添加了@Autowired注解的属性
    // --> 初始化前      调用添加了@PostConstruct注解的方法, 自定义的逻辑
    // --> 初始化        执行InitializingBean接口的方法
    // --> 初始化后
    // --> 进行AOP ---> 代理对象(@Autowired的属性为null)
    // --> bean(属性有值)
    // 如果有AOP，则将代理对象放置到Spring容器中，之后从其中取值

    // TODO: Spring如何判断UserService类/原始对象需要执行AOP? 是否有切面?
    // Aspect切面也是一个bean，会添加到Spring容器中
    // 1. 从Spring容器中找出所有的切面bean
    // 2. 遍历全部的切面bean
    // 3. 遍历每一个切面bean的所有方法，是否有对应的切面(匹配)
    // 4. 如果有，则保存切面方法(代理逻辑)到代理类型，之后会执行

    // 2. Bean的销毁

}
