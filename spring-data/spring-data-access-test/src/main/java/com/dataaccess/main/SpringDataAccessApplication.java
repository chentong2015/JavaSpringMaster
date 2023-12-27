package com.dataaccess.main;

import com.dataaccess.main.das.EnableDataAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;

@SpringBootApplication
@EnableDataAccess
public class SpringDataAccessApplication {

    public static void main(String[] args) {
        System.out.println("Start application..");
        SpringApplication.run(SpringDataAccessApplication.class, args);
    }

    // 判断是否Spring Boot应用，如果是则在启动应用时会注入指定类型的bean
    // 在程序中通过Application Context来拿到指定bean并可invoke它的方法
    public void test() throws NoSuchMethodException, ClassNotFoundException {
        String className = "com.dataaccess.main.context.LegacySpringApplicationContext";
        Class<?> springDataClass = Class.forName(className);
        Method getBeanByClassMethod = springDataClass.getMethod("getBeanByClass", Class.class);
    }

}