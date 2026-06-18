package example;

import example.bean.AroundBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopProjectApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        AroundBean aroundBean = context.getBean(AroundBean.class);
        aroundBean.hello(); // AOP代理对象在调用方法
        System.out.println("------------------------------");
        aroundBean.helloByProxy(); // 主动获取AOP代理对象来调用
    }
}