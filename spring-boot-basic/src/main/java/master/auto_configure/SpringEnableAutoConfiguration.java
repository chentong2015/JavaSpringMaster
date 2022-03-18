package master.auto_configure;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({MyAutoConfigurationImportSelector.class})
public @interface SpringEnableAutoConfiguration {

    // Spring Boot源码自动装配的引入类
    // @Import({AutoConfigurationImportSelector.class})

    // protected List<String> getCandidateConfigurations(AnnotationMetadata metadata,AnnotationAttributes attributes) {
    //        List<String> configurations = SpringFactoriesLoader
    //             .loadFactoryNames(EnableAutoConfiguration.class, this.getBeanClassLoader());
    //        Assert.notEmpty(configurations, "Not found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
    //        return configurations;
    //    }

    // public static List<String> loadFactoryNames(Class<?> factoryType, @Nullable ClassLoader classLoader) {
    //   ClassLoader classLoaderToUse = classLoader;
    //   if (classLoader == null) {
    //       classLoaderToUse = SpringFactoriesLoader.class.getClassLoader();
    //   }
    //   String factoryTypeName = factoryType.getName();
    //   类似于map.get(key, defaultValue)方法调用
    //   return (List)loadSpringFactories(classLoaderToUse)
    //       .getOrDefault(factoryTypeName, Collections.emptyList());
    // }
    //
    //   TODO: 缓存的作用? 读取spring.factories文件中所有信息到cache中，减少磁盘IO，提高性能
    // private static Map<String, List<String>> loadSpringFactories(ClassLoader classLoader) {
    //   Map<String, List<String>> result = (Map)cache.get(classLoader);
    //     Enumeration<URL> urls = classLoader != null ?
    //         classLoader.getResources("META-INF/spring.factories") :
    //         ClassLoader.getSystemResources("META-INF/spring.factories");
    //   ...
    //   Properties properties = PropertiesLoaderUtils.loadProperties(resource);
    //   ...
    // }
}
