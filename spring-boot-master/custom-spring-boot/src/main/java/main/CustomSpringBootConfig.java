package main;

import com.spring.ComponentScan;

// Spring Context的配置文件，定义扫描的路径和要注入的bean
@ComponentScan("main.service")
public class CustomSpringBootConfig {
}
