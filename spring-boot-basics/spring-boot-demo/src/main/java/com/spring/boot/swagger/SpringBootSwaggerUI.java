package com.spring.boot.swagger;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// springfox-swagger 提供UI界面的API请求操作
// https://springfox.github.io/springfox/docs/current/

// @Configuration
// @EnableWebMvc
// @EnableSwagger2
public class SpringBootSwaggerUI implements WebMvcConfigurer {

    // 访问地址http://localhost:8080/swagger-ui.html
    // @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
