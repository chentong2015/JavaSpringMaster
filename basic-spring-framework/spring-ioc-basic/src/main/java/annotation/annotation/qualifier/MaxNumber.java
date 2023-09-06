package annotation.annotation.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @interface 定义一个Annotation注解, 非interface type       ===> C#区别：自定义定制特性custom attribute: [AttributeUsage(AttributeTargets.All)]
 * @Qualifier 该注解表明自定义的annotation可以被当做@Qualifier来使用
 * @Retention(RetentionPolicy.RUNTIME) 声明多久的保留时间, RUNTIME表示会预留到编译器编译后的class file, 同时被JVM预留
 * @Target() 声明注解所作用的目标范围Type, ElementType是枚举类型
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface MaxNumber {

}
