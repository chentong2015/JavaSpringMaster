package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc  // Enable Web MVC的相关配置
public class BasicSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringbootApplication.class, args);
    }
}
