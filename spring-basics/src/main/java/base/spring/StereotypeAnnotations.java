package base.spring;

/**
 * "Stereotype" Annotations: 符合某种固定或者通用的模式 fixed or general pattern !!!
 * 1. 使用注解标记处应用程序中指定的角色 markers for any class as a role within the application
 * 2. 可以有效的减少Spring XML based configuration for these components
 */
public class StereotypeAnnotations {

    /**
     * @Configuration: the configuration for spring container
     * -
     * @Component: generic stereotype for any spring-managed component  ===> 可以替换在xml文件中配置bean
     * @Component("nameComponent") 可以提供指定的component名称
     * -
     * 特定的注解正对指定的应用场景
     * @Repository: for instance
     * @Service: for com.ctong.springboot.service
     * @Controller: for presentation layers
     */
}
