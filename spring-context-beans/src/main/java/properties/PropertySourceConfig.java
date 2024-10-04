package properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 通过@PropertySource引入指定的配置文件
@Configuration
@ComponentScan(basePackages = "properties")
@PropertySource(value = "classpath:application.properties")
public class PropertySourceConfig {

    // 从.properties文件中读取属性值，名称必须一致，提供默认值
    @Value("${key2:10}")
    private int key2;
}
