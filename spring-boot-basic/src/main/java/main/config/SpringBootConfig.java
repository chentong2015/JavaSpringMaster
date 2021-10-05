package main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = {"main.controller"})
public class SpringBootConfig implements WebMvcConfigurer {

    // 自定义配置json转换器
    // Request ---> 流 ---> Json Converter ---> Controller
    // Request <--- 流 <--- Json Converter <--- Controller
    // public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //     converters.add(new MappingJackson2HttpMessageConverter());
    // }

    // API的维护：访问地址http://localhost:8080/swagger-ui.html
    @Bean
    public Docket api() {
        // 使用Builder模式构建
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
