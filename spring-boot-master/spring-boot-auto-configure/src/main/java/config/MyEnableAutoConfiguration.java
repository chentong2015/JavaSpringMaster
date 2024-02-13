package config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

// TODO: 通过注解自动注入Configuration配置(包含bean的声明)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Import({SystemReportingConfiguration.class, SystemIntegrationConfiguration.class})
public @interface MyEnableAutoConfiguration {

}
