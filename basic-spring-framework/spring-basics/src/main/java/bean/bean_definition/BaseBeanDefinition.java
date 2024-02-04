package bean.bean_definition;

// BeanDefinition: spring_framework.bean 定义对象，描述对象:
// AbstractBeanDefinition.java 定义不同的属性，每一个属性都是用来控制某一个流程的
// @Lazy @DependsOn @Scope     通过注解来描述bean的行为和信息

// BeanDefinitionMap<beanName, BeanDefinition>: 存储BeanDefinition的地方
public class BaseBeanDefinition {

    // bean后置处理器BeanPostProcessors: 通过后置处理器在对象初始化前后，修改对象的属性值和特征
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

    // Bean定义中，提供了两种Scopes和三种Role
    // public interface BeanDefinition
    //    String SCOPE_SINGLETON = "singleton";
    //    String SCOPE_PROTOTYPE = "prototype";
    //    int ROLE_APPLICATION = 0;
    //    int ROLE_SUPPORT = 1;
    //    int ROLE_INFRASTRUCTURE = 2;
}
