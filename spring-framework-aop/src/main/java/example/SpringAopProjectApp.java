package example;

import example.bean.AroundBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopProjectApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        AroundBean aroundBean = context.getBean(AroundBean.class);
        aroundBean.hello(); // AOP Proxy 代理对象在调用方法

        // ServiceClass serviceClass = context.getBean(ServiceClass.class);
        // serviceClass.printSomething();
    }
}
