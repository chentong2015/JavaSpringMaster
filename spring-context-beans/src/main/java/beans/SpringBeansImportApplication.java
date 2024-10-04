package beans;

import beans.bean_import.bean.MyBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeansImportApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringBeansConfiguration.class);
        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        applicationContext.refresh();

        // ApplicationContext必须Refresh才能Active
        System.out.println(applicationContext.isActive());

        MyBean myBean = (MyBean) applicationContext.getBean("myBean");
        myBean.print();

        // 检测bean定义是否被BeanFactoryPostProcessor后置处理器修改
        BeanDefinition beanDefinition = applicationContext.getBeanDefinition("myBean");
        System.out.println(beanDefinition.isSingleton());
        System.out.println(beanDefinition.isPrototype());
    }
}
