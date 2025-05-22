package bean_import.condition;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 根据Active的Profile来控制Bean的注入
public class BaseProfileCondition implements ConfigurationCondition {

    private final String activateProfileName;
    private final String deactivateProfileName;

    public BaseProfileCondition(String activateProfileName) {
        this.activateProfileName = activateProfileName;
        this.deactivateProfileName = "No" + activateProfileName;
    }

    @Override
    public ConfigurationPhase getConfigurationPhase() {
        // which the condition should be evaluated.
        return ConfigurationPhase.REGISTER_BEAN;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean activateProfile = false;
        boolean deactivateProfile = false;

        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            if (activateProfileName.equalsIgnoreCase(profile)) {
                activateProfile = true;
            }
            if (deactivateProfileName.equalsIgnoreCase(profile)) {
                deactivateProfile = true;
            }
        }
        return activateProfile && !deactivateProfile;
    }
}
