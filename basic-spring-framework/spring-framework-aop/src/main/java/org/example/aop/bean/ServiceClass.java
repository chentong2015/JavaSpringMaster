package org.example.aop.bean;

import org.springframework.stereotype.Component;

@Component
public class ServiceClass {

    public void printSomething() {
        System.out.println("print something");
    }
}
