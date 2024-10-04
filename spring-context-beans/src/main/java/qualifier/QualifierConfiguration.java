package qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO. Qualifier注解能够解决注入同类型Bean时的冲突问题
// Qualifier为Bean添加一个区分的标记，在使用时通过不同标记来获取不同的Bean对象
@Configuration
public class QualifierConfiguration {

    @Bean
    @MaxNumber
    public int maxNumber() {
        return 20;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return 10;
    }
}
