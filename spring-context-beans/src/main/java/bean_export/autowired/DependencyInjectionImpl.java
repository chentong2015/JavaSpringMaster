package bean_export.autowired;

import org.springframework.beans.factory.annotation.Autowired;

// TODO. Bean DI依赖注入机制 @Autowired
public class DependencyInjectionImpl {

    // TODO. Field based DI 基于属性注入，在创建Bean对象的过程中检测注解完成属性赋值
    // 只有当IOC容器中Bean对象唯一时才能注入成功
    @Autowired
    private BeanDI beanDI;

    // TODO. Constructor based DI 基于构造器注入，在创建Bean的原始对象实例时调用构造器 => 推荐方式
    // 构造器中传递的参数将自动被autowired，因此无需再添加注解 !
    // 构造器中传递的参数不应过多，避免Bean的耦合性高，职责过多 !
    // @Autowired
    public DependencyInjectionImpl(BeanDI beanDI) {
        this.beanDI = beanDI;
    }

    // TODO. Setter based DI 基于设置器注入，Setter方法不会自动被调用，需要添加注解
    // 一般用在可选的依赖，非必须的注入，允许在后期重新配置和重新注入
    @Autowired
    public void setBeanDI(BeanDI beanDI) {
        this.beanDI = beanDI;
    }
}
