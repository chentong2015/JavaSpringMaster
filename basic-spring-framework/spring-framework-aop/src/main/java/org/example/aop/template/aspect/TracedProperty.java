package org.example.aop.template.aspect;

import org.example.aop.template.property.DefaultPropertyExtractor;
import org.example.aop.template.property.PropertiesExtractor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.TYPE_USE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TracedProperty {

    Class<? extends PropertiesExtractor> value() default DefaultPropertyExtractor.class;
}
