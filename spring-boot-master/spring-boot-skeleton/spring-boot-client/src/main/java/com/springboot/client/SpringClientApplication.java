package com.springboot.client;

import com.springboot.api.DemoClass;
import com.springboot.server.EnableSpringBootServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

// 使用自定义的@EnableSpringBootServer注解
// 1. 添加后端默认注入的bean，客户端可通过Configuration更新注入
// 2. 添加后端默认注入的Controller Endpoints，用于接收客户端的请求
@SpringBootApplication
@EnableSpringBootServer
public class SpringClientApplication implements CommandLineRunner {

    @Autowired
    private DemoClass demoClass;

    public static void main(String[] args) {
        SpringApplication.run(SpringClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.demoClass.getName());
        RestTemplate template = new RestTemplate();
        String response = template.getForObject("http://127.0.0.1:8080/v1/server/home", String.class);
        System.out.println(response);
    }
}
