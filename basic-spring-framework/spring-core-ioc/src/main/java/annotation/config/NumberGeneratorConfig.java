package annotation.config;

import annotation.qualifier.GuessCount;
import annotation.qualifier.MaxNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:numberGenerator.properties")
public class NumberGeneratorConfig {

    // 从.properties文件中读取属性值，名称必须一致，提供默认值
    @Value("${generator.maxNumber:100}")
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
