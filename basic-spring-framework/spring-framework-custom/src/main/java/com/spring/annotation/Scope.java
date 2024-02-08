package com.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Spring提供的关于bean的scope作用域
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scope {

    // 1. singleton 单例，只会创建一个bean对象
    // 2. prototype 原型，每个获得均会得到一个新的bean对象
    String value();
}
