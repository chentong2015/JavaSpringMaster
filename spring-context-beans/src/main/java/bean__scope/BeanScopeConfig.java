package bean__scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanScopeConfig {

    // 默认单列Bean，每次从IoC获取同一个Object对象
    @Bean
    @Scope(scopeName = "singleton")
    public Bean1 bean1() {
        return new Bean1();
    }

    // Prototype标明每次从IoC中获取时都创建一个新对象
    @Bean
    @Scope(scopeName = "prototype")
    public Bean2 bean2() {
        return new Bean2();
    }

    class Bean1 { }

    class Bean2 { }
}
