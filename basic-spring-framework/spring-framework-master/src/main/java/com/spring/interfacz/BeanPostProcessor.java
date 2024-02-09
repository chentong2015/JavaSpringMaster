package com.spring.interfacz;

// TODO. bean的后置处理器, 对外提供的一种扩展机制
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}