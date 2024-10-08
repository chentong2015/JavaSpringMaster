package properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// @PropertySource指定加载特定的Property配置文件
@Configuration
@ComponentScan(basePackages = "properties")
@PropertySource(value = {"classpath:source.properties", "classpath:application.properties"})
public class PropertySourceConfig {

    // 通过@Value从.properties文件中读取属性值(名称必须一致)
    // 1. 支持提供属性的默认值
    // 2. 可在任意bean对象中使用该注解获取配置属性的值
    @Value("${key2:value}")
    private String key2;
}
