package master.property.loader;

import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class SpringBootPropertySourceLoader {

    public void testPropertySourceLoader(ConfigurableEnvironment environment) throws FileNotFoundException {
        Resource resource = new InputStreamResource(new FileInputStream("name"));
        PropertiesPropertySourceLoader propertiesPropertySourceLoader = new PropertiesPropertySourceLoader();
        try {
            List<PropertySource<?>> propertySources =
                    propertiesPropertySourceLoader.load("applicationConfig: serviceConfigurationPath", resource);
            propertySources.forEach(environment.getPropertySources()::addLast);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load property source from location", e);
        }
    }
}
