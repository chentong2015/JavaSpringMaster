package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories
// https://www.baeldung.com/spring-data-jpa-query#1-jpql-2
@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
