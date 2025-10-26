package main.bean;

import com.spring.annotation.Component;

@Component
public class MyBean {

    public void print(String beanName) {
        System.out.println(beanName + ": print something");
    }
}
