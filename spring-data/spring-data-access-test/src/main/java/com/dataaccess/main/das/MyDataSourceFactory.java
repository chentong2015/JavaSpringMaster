package com.dataaccess.main.das;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class MyDataSourceFactory {

    @Autowired
    private Environment environment;

    public MyDataSourceFactory() {
        System.out.println("MyDataSourceFactory constructor");
    }

    public void printDataSourceFactory() {
        System.out.println(environment.getProperty("key.name"));

        System.out.println("printDataSourceFactory");
    }
}
