package annotation;

import annotation.bean.MyBean;
import annotation.config.AppCoreConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

public class SpringIocAnnotationDemo {

    // Spring低版本: 注入自定义的Configuration和加载自定义的属性文件
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppCoreConfiguration.class);

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("props.properties"));

        context.addBeanFactoryPostProcessor(configurer);
        context.refresh();

        MyBean bean = context.getBean(MyBean.class);
        bean.print();
    }
}
