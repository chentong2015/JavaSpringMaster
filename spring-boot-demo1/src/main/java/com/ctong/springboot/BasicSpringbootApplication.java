package com.ctong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication: Allow this class to be the Configuration
 * 1. 可以在其中声明beans methods, 完成注入, 但一般在@Configuration配置中注入
 * 2. Scan当前的Package和它所有的subPackages, get components like @Controller, @Service ...
 */
@SpringBootApplication
public class BasicSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringbootApplication.class, args);
    }
}
