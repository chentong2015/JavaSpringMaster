package com.spring.boot.basic.demo.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public interface AppEventListener {

    void onSuccess(SpringApplication springApplication, ConfigurableApplicationContext applicationContext);

    void onFailure(SpringApplication springApplication, Throwable cause);
}
