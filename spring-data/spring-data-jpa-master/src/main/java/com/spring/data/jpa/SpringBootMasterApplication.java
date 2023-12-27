package com.spring.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMasterApplication {

    public static void main(String[] args) {
        System.out.println("Start application..");
        SpringApplication.run(SpringBootMasterApplication.class, args);
    }
}
