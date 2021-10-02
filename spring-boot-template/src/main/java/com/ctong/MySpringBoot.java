package com.ctong;

import com.ctong.spring.boot.MySpringApplication;
import com.ctong.spring.boot.MySpringBootApplication;

@MySpringBootApplication
public class MySpringBoot {

    public static void main(String[] args) {
        MySpringApplication.run(MySpringBoot.class);
    }
}
