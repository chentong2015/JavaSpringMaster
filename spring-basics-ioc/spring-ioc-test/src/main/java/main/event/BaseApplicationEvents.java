package main.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * TODO: Observer Design Pattern 观察着模式：向指定的对象注册观察者，而不用让对象显式的调用你，解耦，构成间接依赖
 * 实现ApplicationListener<T>泛型接口, 来监听event (注册了一个观察者bean)
 * BaseApplicationEvents类会被部署到context, if ApplicationEvent gets published to ApplicationContext, bean is notified
 */
@Component
public class BaseApplicationEvents implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 必须重写指定名称的方法
     * ContextRefreshedEvent: 当Application Context object加载(ready for use)或者刷新时响应的事件 !!
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("On com.ctong.springboot.config start event");
    }
}
