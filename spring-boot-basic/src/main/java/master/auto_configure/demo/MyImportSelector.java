package master.auto_configure.demo;

import master.auto_configure.config.SystemIntegrationConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.List;

// Spring Boot 自动装配
// Version 1: .xml配置
// Version 2: Java配置版本(使用注解)
// Version 3: 使用@Import导入配置类(@Configuration，包含多个bean定义) ==> 硬编码
public class MyImportSelector implements ImportSelector {

    // 方式1: 直接通过完整路径(全类名路径)导入
    // @Override
    // public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    //   return new String[]{"spring_framework.bean.import_bean.Person"};
    // }

    // 方式2: 通过读取properties文件中的配置来解耦 ==> 不推荐
    // @Override
    // public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    //      Properties properties = new Properties();
    //      properties.load(classLoader.getResourceAsStream("auto-main.config.properties"));
    //      String value = properties.getProperty("key");
    //      return new String[]{value};
    // }

    // TODO: 基于SPI机制的自动装配的实现效果
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 从指定的路径下面读取配置文件: spring.factories
        // 提供注解的全类名 SpringBootAutoConfig.class
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
                SystemIntegrationConfiguration.class, MyImportSelector.class.getClassLoader());
        return StringUtils.toStringArray(configurations);
    }

    // public static List<String> loadFactoryNames(Class<?> factoryType,
    //      @Nullable ClassLoader classLoader) {
    //   ClassLoader classLoaderToUse = classLoader;
    //   if (classLoader == null) {
    //       classLoaderToUse = SpringFactoriesLoader.class.getClassLoader();
    //   }
    //   String factoryTypeName = factoryType.getName();
    //   类似于map.get(key, defaultValue)方法调用
    //   return (List)loadSpringFactories(classLoaderToUse)
    //        .getOrDefault(factoryTypeName, Collections.emptyList());
    // }
    //
    // private static Map<String, List<String>> loadSpringFactories(ClassLoader classLoader) {
    //   TODO: 缓存的作用? 读取spring.factories文件中所有信息到cache中，减少磁盘IO，提高性能
    //   Map<String, List<String>> result = (Map)cache.get(classLoader);
    //   Properties properties = PropertiesLoaderUtils.loadProperties(resource);
    //   ...
    // }
}
