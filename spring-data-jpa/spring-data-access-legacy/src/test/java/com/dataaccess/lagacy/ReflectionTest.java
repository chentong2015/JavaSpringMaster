package com.dataaccess.lagacy;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ReflectionTest {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Class<?> springDataClass = Class.forName("com.dataaccess.lagacy.LegacySpringApplicationContext");
        Method getBeanByClassMethod = springDataClass.getMethod("getBeanByClass", Class.class);
        Assert.assertNotNull("method getBeanByClass must have been found", getBeanByClassMethod);
    }

}
