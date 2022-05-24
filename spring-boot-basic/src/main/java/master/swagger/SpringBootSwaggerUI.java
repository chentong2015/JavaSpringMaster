package master.swagger;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// @EnableWebMvc
// @EnableSwagger2
public class SpringBootSwaggerUI implements WebMvcConfigurer {

    // springfox-swagger 提供UI界面的API请求操作
    // https://springfox.github.io/springfox/docs/current/

    // API的维护：访问地址http://localhost:8080/swagger-ui.html
    // @Bean
    // public Docket api() {
    //     return new Docket(DocumentationType.SWAGGER_2)
    //             .select()
    //             .apis(RequestHandlerSelectors.any())
    //             .paths(PathSelectors.any())
    //             .build();
    // }
}
