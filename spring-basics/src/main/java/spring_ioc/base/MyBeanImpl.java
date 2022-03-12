package spring_ioc.base;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// Spring 默认会将类型名称第一个字母小写作为bean的beanName
// 但是如果，类型名称的前两个字母都是大写，spring则不会将第一字母小写
@Component("myBeanImpl")
public class MyBeanImpl implements MyBean {

    @Override
    public void print() {
        System.out.println("Print from my spring_framework.bean");
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

