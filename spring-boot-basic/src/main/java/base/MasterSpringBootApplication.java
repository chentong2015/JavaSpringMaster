package base;

public class MasterSpringBootApplication {

    // 关于@interface SpringBootApplication注解的理解:
    //
    // @Target({ElementType.TYPE})
    // @Retention(RetentionPolicy.RUNTIME)
    // @Documented
    // @Inherited 标明可以从super class上查找注解
    // @SpringBootConfiguration
    //     @Target({ElementType.TYPE})
    //     @Retention(RetentionPolicy.RUNTIME)
    //     @Documented
    //     @Configuration 该注解标明可以在"标明了该注解的类型"使用@Bean注入
    //     @Indexed  Java原生类库中没有提供此注解
    // @SpringBootAutoConfiguration
    //     @Target({ElementType.TYPE})
    //     @Retention(RetentionPolicy.RUNTIME)
    //     @Documented
    //     @Inherited
    //     @AutoConfigurationPackage
    //     @Import({AutoConfigurationImportSelector.class}) 自动装配选择器
    // @ComponentScan(excludeFilters = {
    //     @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
    //     @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class})}
    //     TODO: 这里确定扫描的范围是标注@SpringBootApplication注解的包，及其下面的所有包
    //           扫描所有标注了@Repository, @Service, @Component, @Controller...的类型

    // AutoConfigurationImportSelector >> selectImports() 源码的实现
    // protected AutoConfigurationImportSelector.AutoConfigurationEntry
    //       getAutoConfigurationEntry(AnnotationMetadata annotationMetadata) {
    //       if (!this.isEnabled(annotationMetadata)) {
    //           return EMPTY_ENTRY;
    //       } else {
    //           AnnotationAttributes attributes = this.getAttributes(annotationMetadata);
    //           List<String> configurations = this.getCandidateConfigurations(annotationMetadata, attributes);
    //           去除读取文件中的重复数据
    //           configurations = this.removeDuplicates(configurations);
    //           搜集是否有自定义需要排除的装配
    //           通过@SpringBootApplication(excludeName = {})来设置
    //           Set<String> exclusions = this.getExclusions(annotationMetadata, attributes);
    //           this.checkExcludedClasses(configurations, exclusions);
    //           configurations.removeAll(exclusions);
    //           多虑到没有导入的jar包，从读取的自动装配配置数据中排除
    //           configurations = this.getConfigurationClassFilter().filter(configurations);
    //           this.fireAutoConfigurationImportEvents(configurations, exclusions);
    //           return new AutoConfigurationImportSelector.AutoConfigurationEntry(configurations, exclusions);
    //       }
    //   }
    //
    // protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
    //      List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
    //          this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
    //      Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories.
    //          If you are using a custom packaging, make sure that file is correct.");
    //      return configurations;
    //  }
    //
    // 最终读取文件的位置：spring-boot-autoconfigure-xxx.RELEASE\META-INF\spring.factories
}
