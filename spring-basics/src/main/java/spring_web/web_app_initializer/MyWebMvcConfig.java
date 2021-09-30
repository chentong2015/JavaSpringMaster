package spring_web.web_app_initializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
// 配置扫描的package包，指定扫描特定的类型
@ComponentScan(basePackages = {"spring_web"},
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestController.class})})
public class MyWebMvcConfig implements WebMvcConfigurer {

    // 文件上传和下载的组件
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        return multipartResolver;
    }
}
