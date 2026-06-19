package example;

import example.component.HelloComponent;
import example.model.MainItem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopProjectApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnableAopConfig.class);
        HelloComponent component = context.getBean(HelloComponent.class);

        component.base(); // 原始对象调用方法
        component.hello(); // AOP代理对象在调用方法
        component.helloByProxy(); // 主动获取AOP代理对象来调用
        component.helloItem(new MainItem()); // 测似拦截对象参数
    }
}