package main.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 2. 通过Annotation注解来标识对指定事件的监听
 */
@Component
public class DemoApplicationEvents {

    /**
     * 作为@EventListener标记的方法，必须提供要监听的事件的类型作为方法参数 !!
     */
    @EventListener
    public void initOrRefresh(ContextRefreshedEvent contextRefreshedEvent) {
        String name = contextRefreshedEvent.getApplicationContext().getApplicationName();
        System.out.println("Listen event: start ..." + name);
    }

    /**
     * 直接在声明注解时传递监听的事件类型
     */
    @EventListener(ContextRefreshedEvent.class)
    public void initOrRefreshContext() {
        System.out.println("init or refresh context.");
    }
}
