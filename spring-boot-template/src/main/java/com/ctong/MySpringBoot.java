package com.ctong;

import com.ctong.spring.boot.MySpringApplicationStarter;
import com.ctong.spring.boot.MySpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MySpringBootApplication
public class MySpringBoot {

    // 自定义注入的bean，作为添加到Tomcat中的Servlet
    @Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        return dispatcherServlet;
    }

    public static void main(String[] args) {
        MySpringApplicationStarter.run(MySpringBoot.class);
    }
}
