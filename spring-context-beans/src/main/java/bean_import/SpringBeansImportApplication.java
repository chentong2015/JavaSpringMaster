package bean_import;

import bean_import.bean.MyBean;
import bean_import.configuration.SpringBeansConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeansImportApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(SpringBeansConfiguration.class);
        appContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        appContext.refresh();

        // ApplicationContext必须Refresh才能Active
        System.out.println(appContext.isActive());

        MyBean myBean = (MyBean) appContext.getBean("myBean");
        myBean.print();

        // 检测bean定义是否被BeanFactoryPostProcessor后置处理器修改
        BeanDefinition beanDefinition = appContext.getBeanDefinition("myBean");
        System.out.println(beanDefinition.isSingleton());
        System.out.println(beanDefinition.isPrototype());
    }
}
