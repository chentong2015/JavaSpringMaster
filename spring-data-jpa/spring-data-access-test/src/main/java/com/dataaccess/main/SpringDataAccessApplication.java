package com.dataaccess.main;

import com.dataaccess.layer.EnableDataAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDataAccess
@PropertySource("classpath:application.properties")
public class SpringDataAccessApplication {

    public static void main(String[] args) {
        System.out.println("Start application..");
        SpringApplication.run(SpringDataAccessApplication.class, args);
    }
}