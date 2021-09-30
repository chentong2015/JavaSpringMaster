package spring_web.config;

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
@ComponentScan(basePackages = {"spring_web"}, includeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestController.class})})
public class MyWebMvcConfig implements WebMvcConfigurer {

    // @EnableWebMvc的作用: 处理映射的功能
    // 1. TODO: 确保IoC容器中必须包含ServletContext，否则会报错
    // 2. 容器启动的时候，找容器中所有实现WebMvcConfigurer接口的类型，调用到指定的方法
    // @Import({DelegatingWebMvcConfiguration.class})
    //    @Autowired(required = false)
    //    public void setConfigurers(List<WebMvcConfigurer> configurers) {
    //        if (!CollectionUtils.isEmpty(configurers)) {
    //            this.configurers.addWebMvcConfigurers(configurers);
    //        }
    //    }

    @Bean
    public MultipartResolver multipartResolver() {
        // 文件上传和下载的组件
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10);
        return multipartResolver;
    }
}
