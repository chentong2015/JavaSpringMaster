package com.springboot.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Configuration
@Import(ServerConfiguration.class)
public @interface EnableSpringBootServer {

    // 自定义注解注入Server端提供的Configuration
}
