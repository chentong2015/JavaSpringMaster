package beans_lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("myBeanLifecycle")
public class MyBeanLifecycle {

    public void print() {
        System.out.println("Print from my spring_framework.bean");
    }

    // Bean生命周期的回调
    @PostConstruct
    public void init() {
        System.out.println("Post Construct Object");
    }

    // 在bean的生命周期中自动回调的方法
    // PreDestroy annotation is used on signal that instance is in the process of being removed by container
    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre destroy generator object");
    }
}

