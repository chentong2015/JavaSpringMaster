package spring_ioc.base;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyBeanImpl implements MyBean {

    @Override
    public void print() {
        System.out.println("Print from my bean");
    }

    // Bean生命周期的回调
    @PostConstruct
    public void init() {
        System.out.println("Post Construct Object");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre destroy generator object");
    }
}

