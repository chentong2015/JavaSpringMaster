package bean_import.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 基于特定的Condition条件来注入Bean
// @Bean
// @Conditional(OnLiunxCondition.class)

public class OnLiunxCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String os = context.getEnvironment().getProperty("os.name");
        return os != null && os.contains("uni");
    }
}
