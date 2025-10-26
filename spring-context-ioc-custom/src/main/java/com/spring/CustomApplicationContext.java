package com.spring;

import com.spring.annotation.*;
import com.spring.interfacz.BeanPostProcessor;
import com.spring.factory.CustomBeanFactory;
import com.spring.model.BeanDefinition;
import com.spring.processor.BeanFactoryPostProcessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 自定义的Spring Context容器类
// 包含bean对象以及bean定义的缓存池，方便快速获取
public class CustomApplicationContext {

    private Class configClass;
    private CustomBeanFactory beanFactory;
    private ConcurrentHashMap<String, Object> singletonObjects;  // bean单例池存储所有单例对象
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap; // 存储bean定义的map

    // BeanFactoryPostProcessors to apply on refresh.
    private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<>();

    // 解析Config类型上有那些Spring提供的注解, 扫描所有的Components
    public CustomApplicationContext(Class configClass) {
        this.configClass = configClass;
        this.beanFactory = new CustomBeanFactory(this);
        this.singletonObjects = new ConcurrentHashMap<>();
        this.beanDefinitionMap = new ConcurrentHashMap<>();
    }

    public void refresh() {
        scanComponents();

        // Bean工厂后置处理器, 在创建Bean对象前修改Bean定义
        invokeBeanFactoryPostProcessors();

        initSingletonBean();
    }

    private void scanComponents() {
        // 获取注解中定义的属性值
        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String pathScan = componentScan.value().replace(".", "/");
        // 拿到指定路径下加载的类型
        List<File> fileList = FileResourceLoader.getClassFiles(pathScan);
        List<String> classNameList = FileResourceLoader.getClassNamesFromFiles(fileList);
        for (String className: classNameList) {
            parseBeanDefinitions(className);
        }
    }

    // 扫描特定注解的类型, 解析类并生成BeanDefinition
    private void parseBeanDefinitions(String className) {
        try {
            Class<?> clazz = CustomApplicationContext.class.getClassLoader().loadClass(className);
            if (clazz.isAnnotationPresent(Component.class)) {
                // 获取Component注解设置的值，默认使用类型名称作为bean的名称
                Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                String beanName = componentAnnotation.value();
                if (beanName == null || beanName.isEmpty()) {
                    beanName = clazz.getSimpleName();
                }

                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setClazz(clazz);
                if (clazz.isAnnotationPresent(Scope.class)) {
                    Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                    beanDefinition.setScope(scopeAnnotation.value());
                } else {
                    beanDefinition.setScope("singleton");
                }
                beanDefinitionMap.put(beanName, beanDefinition);

                // TODO. 判断继承特殊接口的类型, Spring源码使用getBean()来创建的bean实例本身
                //  在这里直接创建，类型本身的属性没有办法被依赖注入
                if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                    BeanPostProcessor instance = (BeanPostProcessor)
                            clazz.getDeclaredConstructor().newInstance();
                    this.beanFactory.addBeanPostProcessor(instance);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor) {
        this.beanFactoryPostProcessors.add(postProcessor);
    }

    private void invokeBeanFactoryPostProcessors() {
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessors) {
            beanFactoryPostProcessor.postProcessBeanFactory(this.beanFactory);
        }
    }

    // TODO. 根据bean definition中的Scope来确定bean初始化时机
    private void initSingletonBean() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet() ) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if (beanDefinition.getScope().equals("singleton")) {
               Object bean = this.beanFactory.doCreateBean(beanName, beanDefinition);
               singletonObjects.put(beanName, bean);
            }
        }
    }

    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                return singletonObjects.get(beanName);
            } else if (beanDefinition.getScope().equals("prototype")) {
                // Create new instance for each time
                return this.beanFactory.doCreateBean(beanName, beanDefinition);
            } else {
                throw new RuntimeException("Bean scope exception");
            }
        } else {
            throw new NullPointerException("Can not find the bean");
        }
    }

    // 支持根据类型来从IoC容器中获取bean对象
    public <T> T getBean(Class<T> clazz) {
        for (BeanDefinition beanDefinition: beanDefinitionMap.values()) {
            if (beanDefinition.getClazz().equals(clazz)) {
                // get bean based on scope
            }
        }
        return null;
    }
}
