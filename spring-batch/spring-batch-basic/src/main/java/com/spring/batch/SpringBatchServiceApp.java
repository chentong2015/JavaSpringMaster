package com.spring.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableBatchProcessing
public class SpringBatchServiceApp {

    public static void main(String[] args) {
        System.out.println("Start application..");
        SpringApplication.run(SpringBatchServiceApp.class, args);
    }
}
