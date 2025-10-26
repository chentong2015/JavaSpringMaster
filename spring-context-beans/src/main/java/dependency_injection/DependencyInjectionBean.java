package dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO. 三种DI依赖注入Bean机制
// 1. Field based DI 基于属性注入
// 2. Constructor based DI 基于构造器注入 => 推荐方式
// 3. Setter based DI 基于设置器注入
public class DependencyInjectionBean {

    // TODO. 创建Bean对象过程中检测注解完成属性赋值
    // 只有当IOC容器中Bean对象唯一时才能注入成功
    @Autowired
    private BeanDI beanDI;

    // TODO. 为什么使用构造器注入: 可以顺序依赖注入多个Bean对象 !!
    // @Autowired 无需添加注解, 构造器参数将自动被autowired
    public DependencyInjectionBean(BeanDI beanDI) {
        this.beanDI = beanDI;
    }

    // TODO. Setter方法不会自动被调用，需要添加注解
    // 一般用在可选依赖，非必须注入，允许在后期重新配置和重新注入
    @Autowired
    public void setBeanDI(BeanDI beanDI) {
        this.beanDI = beanDI;
    }


    @Component
    public class BeanDI {
    }
}
