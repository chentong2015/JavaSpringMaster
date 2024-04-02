package com.spring.batch.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class StepCondition implements Condition {

    // 根据特定的条件来执行Step
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // context.getEnvironment().getActiveProfiles();
        return true;
    }
}
