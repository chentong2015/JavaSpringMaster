package com.dataaccess.main;

import com.dataaccess.layer.EnableDataAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDataAccess
public class SpringDataAccessApplication {

    public static void main(String[] args) {
        System.out.println("Start application..");
        SpringApplication.run(SpringDataAccessApplication.class, args);
    }
}