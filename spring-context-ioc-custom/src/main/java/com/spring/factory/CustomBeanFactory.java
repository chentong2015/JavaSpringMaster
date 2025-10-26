package com.spring.factory;

import com.spring.CustomApplicationContext;
import com.spring.annotation.Autowired;
import com.spring.annotation.PostConstruct;
import com.spring.interfacz.BeanNameAware;
import com.spring.interfacz.BeanPostProcessor;
import com.spring.interfacz.InitializingBean;
import com.spring.model.BeanDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

// TODO. Bean Factory: 根据bean definition来创建bean的对象
// (完成所有依赖注入，Aware，Init，PostProcessor)
public class CustomBeanFactory {

    // 存储所有bean的后置处理器，在创建bean时执行后置的处理
    // TODO. 使用CopyOnWriteArrayList读写分离提高线程安全性
    private CopyOnWriteArrayList<BeanPostProcessor> beanPostProcessorList;
    private CustomApplicationContext applicationContext;

    public CustomBeanFactory(CustomApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        beanPostProcessorList = new CopyOnWriteArrayList<>();
    }

    public Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        try {
            // 实例化: 通过Class反射(调用无餐构造器)得到一个bean的新对象
            // TODO. 默认调用的是无参构造器，Spring会推断使用那个构造方法
            Class clazz = beanDefinition.getClazz();
            Object instance = clazz.getDeclaredConstructor().newInstance();

            this.populateBean(clazz, instance);
            return this.initializeBean(beanName, instance);
        } catch (Exception exception) {
            throw new RuntimeException("Failed to create bean object", exception);
        }
    }

    public void populateBean(Class clazz, Object instance) throws IllegalAccessException, InvocationTargetException {
        // 依赖注入: 给指定对象的指定属性赋值, 根据属性的名称来查找/创建
        for (Field declaredField: clazz.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Autowired.class)) {
                Object filedInstance = this.applicationContext.getBean(declaredField.getName());
                if (filedInstance == null) {
                    // 没有办法注入bean
                }
                declaredField.setAccessible(true);
                declaredField.set(instance, filedInstance);
            }
        }

        // PostConstruct: 调用所有标记该注解的方法, 对于含参方法还需提供参数/依赖注入
        for (Method method: clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.setAccessible(true);
                method.invoke(instance, null);
            }
        }
    }

    public Object initializeBean(String beanName, Object bean) throws Exception {
        // Aware回调: 回调特殊方法的实现(继承自特殊接口)
        if (bean instanceof BeanNameAware) {
            ((BeanNameAware) bean).setBeanName(beanName);
        }

        Object wrappedBean = bean;

        // postProcessBeforeInitialization 后置处理器, 初始化前
        for (BeanPostProcessor beanPostProcessor: beanPostProcessorList) {
            wrappedBean = beanPostProcessor.postProcessBeforeInitialization(wrappedBean, beanName);
        }

        // Init初始化: 执行自定义的初始化逻辑，验证bean初始化是否正确
        if (wrappedBean instanceof InitializingBean) {
            ((InitializingBean) wrappedBean).afterPropertiesSet();
        }

        // TODO. 初始化后返回的对象才是Spring容器总真正的对象(或代理对象)
        for (BeanPostProcessor beanPostProcessor: beanPostProcessorList) {
            wrappedBean = beanPostProcessor.postProcessAfterInitialization(wrappedBean, beanName);
        }
        return wrappedBean;
    }

    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessorList.add(beanPostProcessor);
    }

    public BeanDefinition getBeanDefinition(String beanName) {
       return this.applicationContext.getBeanDefinition(beanName);
    }
}
