package properties.property_source;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 通过@PropertySource引入指定的配置文件
@Configuration
@ComponentScan(basePackages = "properties.property_source")
@PropertySource(value = "classpath:application.properties")
public class PropertySourceConfig {
}
