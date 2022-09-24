package com.spring.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 使用注解来注入Repositories和Entities
@SpringBootApplication
@EnableJpaRepositories("com.spring.data.jpa.repositories")
@EntityScan("com.spring.data.jpa.entity")
public class SpringBootMasterApplication {

    public static void main(String[] args) {
        System.out.println("Start application..");
        SpringApplication.run(SpringBootMasterApplication.class, args);
    }
}
