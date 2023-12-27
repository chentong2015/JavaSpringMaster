package com.boot.template;

import com.boot.template.spring.boot.MySpringApplicationStarter;
import com.boot.template.spring.boot.MySpringBootApplication;

@MySpringBootApplication
public class MySpringBoot {

    // @Bean
    // public DispatcherServlet dispatcherServlet() {
    //     DispatcherServlet dispatcherServlet = new DispatcherServlet();
    //     return dispatcherServlet;
    // }
    //
    // TODO: 可以将自定义的bean(DispatcherServlet)动态配置到tomcat启动时
    // DispatcherServlet myDispatcherServlet = appContext.getBean(DispatcherServlet.class);
    // myDispatcherServlet.setApplicationContext(appContext);

    public static void main(String[] args) {
        MySpringApplicationStarter.run(MySpringBoot.class);
        System.out.println("App started");
    }
}
