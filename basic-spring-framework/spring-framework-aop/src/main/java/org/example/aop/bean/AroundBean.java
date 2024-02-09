package org.example.aop.bean;

import org.springframework.stereotype.Component;

@Component
public class AroundBean {

    public void hello() {
        System.err.println("in hello");
    }
}
