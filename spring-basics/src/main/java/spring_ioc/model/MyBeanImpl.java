package spring_ioc.model;

import org.springframework.stereotype.Component;

@Component
public class MyBeanImpl implements MyBean {

    @Override
    public void print() {
        System.out.println("Print from my bean");
    }
}
