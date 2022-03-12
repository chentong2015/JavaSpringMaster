package main.annotation.qualifier;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Qualifier: Annotation apply to bean 解决注入多个同类型的bean的问题
 * 1. A qualifier is an annotation that apply to a bean
 * 2. 通过标记自定义的Qualifier Annotation, 可以选择特定的bean注入指定的argument
 */
public class BaseQualifier {

    /**
     * 1. 这里的变量名称必须和bean method方法的名称一致，才能完整自动注入 !
     * 2. 使用指定的Qualifier Annotation来实现注入, 和方法名称无关 !!
     */
    @Autowired
    @MaxNumber
    private int maxNumber;
}
