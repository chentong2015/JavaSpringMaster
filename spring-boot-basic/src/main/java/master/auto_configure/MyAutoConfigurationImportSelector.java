package master.auto_configure;

import master.auto_configure.demo.SystemIntegrationConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.List;

public class MyAutoConfigurationImportSelector implements ImportSelector {

    // 方式1: 直接通过完整路径(全类名路径)导入 ==> 不推荐
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
        // 从指定的路径下面读取配置文件: META-INF/spring.factories
        // 提供注解的全类名 SystemIntegrationConfiguration.class
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
                SystemIntegrationConfiguration.class, MyAutoConfigurationImportSelector.class.getClassLoader());
        return StringUtils.toStringArray(configurations);
    }
}
