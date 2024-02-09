package main;

import com.spring.CustomApplicationContext;
import main.service.UserService;

public class CustomSpringBootApplication {

    public static void main(String[] args) {
        CustomApplicationContext context = new CustomApplicationContext(CustomSpringBootConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
    }
}
