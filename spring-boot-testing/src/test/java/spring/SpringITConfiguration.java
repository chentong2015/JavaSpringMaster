package spring;

import org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;

@Configuration
public class SpringITConfiguration {

    // TODO. 配置同测试中启动两个Spring boot应用，需要将启动的App组成一个RuleChain
    // 模拟一个作为client端(内层启动) + Server端(提供Controller)
    @Bean
    ObjectNamingStrategy objectNamingStrategy() {
        ParentAwareNamingStrategy namingStrategy =
                new ParentAwareNamingStrategy(new AnnotationJmxAttributeSource());
        namingStrategy.setEnsureUniqueRuntimeObjectNames(true);
        return namingStrategy;
    }
}
