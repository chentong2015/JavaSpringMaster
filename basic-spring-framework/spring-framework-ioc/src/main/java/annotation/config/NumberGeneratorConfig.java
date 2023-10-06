package annotation.config;

import annotation.qualifier.GuessCount;
import annotation.qualifier.MaxNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Modularizing configurations: 抽象出一个类型的配置, 同时将该配置引入到Application configuration中
 * In Configuration class loads properties file 在配置类型中添加配置file内容
 * 1. 将配置提取到properties file属性配置文件中: 解决硬编码的问题
 * 2. properties file是一种包含(key=value)的text file
 * 3. @PropertySource 从指定的路径加载property file, classpath:配置文件一般存在classpath路径下面
 */
@Configuration
// Add PropertySource with lowest search precedence
// 也可以直接在XML中添加配置文件 <context:property-placeholder ...>
@PropertySource("classpath:numberGenerator.properties")
public class NumberGeneratorConfig {

    /**
     * 从properties中提取指定的值注入 default value expression for the argument
     * 1. 所提取的名称字符串必须完全一致, 从string转换成int类型的值 parseInt()
     * 2. TODO. 如果在properties file无法找到指定的值，则使用提供的默认值 !!
     */
    @Value("${generator.maxNumber:100}")  // Find key in PropertySource
    private int maxNumber;

    @Value("${generator.guessCount:10}")
    private int guessCount = 20;

    private String value;

    // 使用Setter Inject方式来注入配置文件中的信息
    @Autowired
    public void setValue(@Value("${generator.testValue") String value) {
        this.value = value;
        System.out.println(this.value);
    }

    @Bean // Container will create bean from this method
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
