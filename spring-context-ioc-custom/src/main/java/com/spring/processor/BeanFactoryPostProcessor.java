package com.spring.processor;

import com.spring.factory.CustomBeanFactory;

@FunctionalInterface
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(CustomBeanFactory beanFactory);
}
