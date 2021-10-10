package auto_configure;

// 1. 如何自动的?
//    1.1 @EnableAutoConfiguration通过@Import导入bean定义，使用ImportSelector批量导入
//    1.2 通过SPI机制读取\META-INF\spring.factories文件中配置类, 批量加载bean定义，自动解析
// 2. 装配的对象是什么? Bean Definition
public class EnableAutoConfiguration {

    // @Target({ElementType.TYPE})
    // @Retention(RetentionPolicy.RUNTIME)
    // @Documented
    // @Inherited
    // @AutoConfigurationPackage
    // @Import({AutoConfigurationImportSelector.class})
    // public @interface EnableAutoConfiguration {}
}
