package com.dataaccess.main.context;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public final class ReflectionTest {

    @Test
    public void test() throws NoSuchMethodException, ClassNotFoundException {
        Class<?> springDataClass = Class.forName("com.dataaccess.main.context.LegacySpringApplicationContext");
        Method getBeanByClassMethod = springDataClass.getMethod("getBeanByClass", Class.class);
        Assert.assertNotNull("method getBeanByClass must have been found", getBeanByClassMethod);
    }

}
