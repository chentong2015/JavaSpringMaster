package com.dataaccess.main.context;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Wrapper to always return a reference to the Spring Application Context from within non-Spring enabled beans. Unlike
 * Spring MVC's WebApplicationContextUtils we do not need a reference to the Servlet context for this. All we need is
 * for this bean to be initialized during application startup.
 */
public class LegacySpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext legacyContext;
    private ApplicationContext currentContext;

    @Override
    public void setApplicationContext(ApplicationContext context) {
        System.out.println(context.getApplicationName());
        System.out.println(context.getDisplayName());

        currentContext = context;
        if (legacyContext == null) {
            setContext(context);
        } else {
            throw new NoUniqueBeanDefinitionException(ApplicationContext.class, "Several application contexts found, failing");
        }
    }

    private static synchronized void setContext(ApplicationContext context) {
        legacyContext = context;
    }

    private static void resetContext() {
        setContext(null);
    }

    public static Object getBean(String beanName) {
        return legacyContext.getBean(beanName);
    }

    public static Object getBeanByClass(Class<?> classz) {
        return legacyContext.getBean(classz);
    }
}
