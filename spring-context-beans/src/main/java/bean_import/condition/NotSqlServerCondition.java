package bean_import.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

// 设置非特定数据库的条件
public class NotSqlServerCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] profiles = context.getEnvironment().getActiveProfiles();
        return Arrays.stream(profiles).noneMatch(
                profile -> profile.equalsIgnoreCase("sqlserver"));
    }
}