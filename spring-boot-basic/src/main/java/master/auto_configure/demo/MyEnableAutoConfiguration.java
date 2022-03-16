package master.auto_configure.demo;

import master.auto_configure.config.SystemIntegrationConfiguration;
import master.auto_configure.config.SystemReportingConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

// Spring Boot中启动自动装配的注解
// @Target({ElementType.TYPE})
// @Retention(RetentionPolicy.RUNTIME)
// @Documented
// @Inherited
// @AutoConfigurationPackage
// @Import({AutoConfigurationImportSelector.class})
// public @interface SpringBootAutoConfiguration {}

// TODO: 通过注解，自动映入Configuration配置(包含bean的声明)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Import({
        SystemReportingConfiguration.class,
        SystemIntegrationConfiguration.class
})
public @interface MyEnableAutoConfiguration {

}
