package template;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO. 通过注解引入自定义的Aspect切面Bean对象
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import(TracingAspectConfiguration.class)
public @interface EnableTracing {
}
