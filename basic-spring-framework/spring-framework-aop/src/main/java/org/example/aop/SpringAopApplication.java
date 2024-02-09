package org.example.aop;

import org.example.aop.bean.AroundBean;
import org.example.aop.bean.ServiceClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        AroundBean aroundBean = context.getBean(AroundBean.class);
        aroundBean.hello();

        ServiceClass serviceClass =  context.getBean(ServiceClass.class);
        serviceClass.printSomething();
    }
}
