package com.boot.template;

import com.boot.template.spring.boot.MySpringApplicationStarter;

@com.boot.template.spring.boot.MySpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        MySpringApplicationStarter.run(MySpringBootApplication.class);
        System.out.println("App started");
    }
}
