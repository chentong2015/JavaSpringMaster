package main;

import com.spring.CustomApplicationContext;

public class CustomSpringBootApplication {

    public static void main(String[] args) {
        CustomApplicationContext context = new CustomApplicationContext(CustomSpringBootConfig.class);
        // Object object = context.getBean("name");
    }
}
