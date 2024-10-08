package environment;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.StreamSupport;

@Component
public class EnvironmentContextListener {

    // 监听ContextRefreshedEvent刷新事件，显示Environment环境中配置的属性
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();

        String activeProfiles = Arrays.toString(env.getActiveProfiles());
        System.out.println("Active profiles: " + activeProfiles);

        MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();
        StreamSupport.stream(sources.spliterator(), false)
                .filter(EnumerablePropertySource.class::isInstance)
                .map(ps -> ((EnumerablePropertySource<?>) ps).getPropertyNames())
                .flatMap(Arrays::stream)
                .distinct()
                .filter(prop -> !(prop.contains("credentials") || prop.contains("password")))
                .forEach(prop -> System.out.println(prop + env.getProperty(prop)));
    }
}
