package annotation;

import annotation.bean.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocAnnotationDemo {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class)) {
            MyBean bean = context.getBean(MyBean.class);
            bean.print();
        }
    }
}
