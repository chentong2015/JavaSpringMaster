package com.aspectj.template.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(TracingAspectConfiguration.class)
public @interface EnableTracing {

    // TODO. 添加注解来引入指定的Bean, 提供自定义的注解以及Aspect切面逻辑
}
