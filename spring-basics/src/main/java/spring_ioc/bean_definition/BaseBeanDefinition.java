package spring_ioc.bean_definition;

// BeanDefinition对象: 通过注解来描述bean的行为和信息
// AbstractBeanDefinition.java 定义不同的属性 ==> 最终存放在BeanDefinitionMap
// @Lazy
// @DependsOn
// @Scope
public class BaseBeanDefinition {

    // bean的后置处理器BeanPostProcessors: 通过后置处理器在对象初始化前后，修改对象的属性值和特征
    //   AbstractAutowireCapableBeanFactory.initializeBean()
    //   applyBeanPostProcessorsBeforeInitialization()   初始化前
    //   invokeInitMethods(beanName, wrappedBean, mbd);  初始化
    //   applyBeanPostProcessorsAfterInitialization()    初始化后

    // 1. class属性控制最终生成的对象

    // 2. autowireMode注入模型
    //    0 默认ComponentScan扫描出来的bean, 需要显式的添加@Autowired
    //    1 BY_NAME 属性注入
    //    2 BY_TYPE 属性设置
    //    3 构造器注入模式

    // 3. constructorArgumentValues
    // TODO: bean被扫描被管理的时候，会自动的调用无参构造器
    public BaseBeanDefinition() {
        System.out.println("无参构造器");
    }

    public BaseBeanDefinition(String name) {
        System.out.println(name);
    }
}
