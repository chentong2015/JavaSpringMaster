package com.dataaccess.layer;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Import({DataAccessConfiguration.class})
public @interface EnableDataAccess {

}
