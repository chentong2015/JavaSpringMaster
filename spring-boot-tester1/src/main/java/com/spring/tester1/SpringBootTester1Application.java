package com.spring.tester1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootTester1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTester1Application.class, args);
    }
}
