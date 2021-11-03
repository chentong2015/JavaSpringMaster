package spring_framework.bean.bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// 如何拿到Spring生成的bean的名称
// 如何获取创建bean的bean工厂
@Component
public class BaseBeanAware implements BeanNameAware, ApplicationContextAware {

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // applicationContext 拿到bean factory
    }
}
