package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// TODO. 从Spring IoC中获取注入bean
// 1. @Autowired + Constructor + 方法参数自动查找
// 2. 从applicationContext中获取bean工厂和指定的bean(通过名称或者类型)
@Component
public class ApplicationContextBeanExport implements BeanNameAware, ApplicationContextAware {

    private String beanName;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
}
