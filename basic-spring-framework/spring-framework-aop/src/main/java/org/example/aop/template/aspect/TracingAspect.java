package org.example.aop.template.aspect;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aop.template.property.PropertiesExtractor;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
public class TracingAspect {

    // * *(..) 任意的方法原型，拦截所有被标记@Traced注解的方法
    @Around(value = "execution(* *(..)) && @annotation(traced)")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint, Traced traced) throws Throwable {
        Map<String, JsonNode> properties = getProperties(proceedingJoinPoint, traced);
        System.out.println(properties.size());
        
        // 调用执行被切入的方法
        return proceedingJoinPoint.proceed();
    }

    // TODO. 通过ProceedingJoinPoint获取被切入的方法上的参数信息
    private static Map<String, JsonNode> getProperties(ProceedingJoinPoint proceedingJoinPoint, Traced traced) throws ReflectiveOperationException {
        Map<String, JsonNode> properties = getParametersProperties(proceedingJoinPoint);
        properties.putAll(getFieldsProperties(proceedingJoinPoint));

        properties.computeIfAbsent("dataSize", s -> TextNode.valueOf(traced.operation()));
        return properties;
    }

    private static Map<String, JsonNode> getParametersProperties(ProceedingJoinPoint proceedingJoinPoint) throws ReflectiveOperationException {
        Parameter[] parameters = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod().getParameters();
        String[] parameterNames = ((CodeSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        Map<String, JsonNode> properties = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Object value = proceedingJoinPoint.getArgs()[i];
            properties.putAll(getObjectProperties(parameter, parameterNames[i], value));
        }
        return properties;
    }

    // TODO. 通过ProceedingJoinPoint获取被切入方法的类型上的属性信息(标记特殊注解的属性)
    private static Map<String, JsonNode> getFieldsProperties(ProceedingJoinPoint proceedingJoinPoint) {
        return Arrays.stream(proceedingJoinPoint.getTarget().getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(TracedProperty.class))
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    try {
                        return getObjectProperties(field, field.getName(), field.get(proceedingJoinPoint.getTarget()));
                    } catch (ReflectiveOperationException e) {
                        throw new RuntimeException(e);
                    }
                })
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static <T> Map<String, JsonNode> getObjectProperties(AnnotatedElement annotatedElement, String name, Object value)
            throws ReflectiveOperationException {
        TracedProperty tracedProperty = annotatedElement.getAnnotation(TracedProperty.class);
        if (tracedProperty == null) {
            return Collections.emptyMap();
        }
        PropertiesExtractor propertiesExtractor = tracedProperty.value().getDeclaredConstructor().newInstance();
        return propertiesExtractor.extract(name, (T) value);
    }
}
