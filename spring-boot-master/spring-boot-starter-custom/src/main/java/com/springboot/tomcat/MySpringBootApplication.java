package com.springboot.tomcat;

@IMySpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        MySpringApplicationStarter.run(MySpringBootApplication.class);
        System.out.println("App started");
    }
}
