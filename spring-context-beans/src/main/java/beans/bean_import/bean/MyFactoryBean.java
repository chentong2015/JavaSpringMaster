package beans.bean_import.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

// TODO. 继承FactoryBean工厂, 以bean的风格来定义bean
// A bean that implements this interface cannot be used as a normal bean.
// A FactoryBean is defined in a bean style.
@Component
public class MyFactoryBean implements FactoryBean<MyBean> {

    // getObject()返回实际构建的bean对象
    // The object exposed for bean references (getObject()) is always the object that it creates
    @Override
    public MyBean getObject() throws Exception {
        return new MyBean();
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    // 定义创建的Bean的Scope
    // FactoryBeans can support singletons and prototypes,
    // and can either create objects lazily on demand or eagerly on startup
    @Override
    public boolean isSingleton() {
        return true;
    }
}
