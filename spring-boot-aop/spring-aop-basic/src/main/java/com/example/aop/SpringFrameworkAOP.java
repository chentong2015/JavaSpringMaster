package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring AOP编程:
// 1. @EnableAspectJAutoProxy 激活AspectJ方面编程
// 2. @Aspect @Component      注入Aspect Bean
// 3. @Pointcut               定义切入点以及执行的逻辑

@SpringBootApplication
public class SpringFrameworkAOP {

    public static void main(String[] args) {
        SpringApplication.run(SpringFrameworkAOP.class, args);
    }
}
