package spring_boot;

public class BaseSpringBootApplication {

    // 关于@interface SpringBootApplication注解的理解:
    //
    // @Target({ElementType.TYPE})
    // @Retention(RetentionPolicy.RUNTIME)
    // @Documented
    // TODO @Inherited
    // @SpringBootConfiguration
    //     @Target({ElementType.TYPE})
    //     @Retention(RetentionPolicy.RUNTIME)
    //     @Documented
    //     @Configuration 该注解标明可以在标明了该注解的类型使用@Bean注入
    //     TODO @Indexed
    // @EnableAutoConfiguration
    //     @Target({ElementType.TYPE})
    //     @Retention(RetentionPolicy.RUNTIME)
    //     @Documented
    //     @Inherited
    //     @AutoConfigurationPackage
    //     @Import({AutoConfigurationImportSelector.class})
    // @ComponentScan(
    //     excludeFilters = {@Filter(
    //     type = FilterType.CUSTOM,
    //     classes = {TypeExcludeFilter.class}
    // ), @Filter(
    //     type = FilterType.CUSTOM,
    //     classes = {AutoConfigurationExcludeFilter.class}
    // )}

}
