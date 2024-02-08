package com.spring;

import com.spring.annotation.*;
import com.spring.interfacz.BeanNameAware;
import com.spring.interfacz.BeanPostProcessor;
import com.spring.interfacz.InitializingBean;
import com.spring.model.BeanDefinition;
import com.spring.util.FileResourcesUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 自定义的Spring Context容器类
public class CustomApplicationContext {

    private Class configClass;

    // TODO. 以下所有的属性都封装在BeanFactory工厂中
    // bean的单例池，存储所有的单例bean的对象
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    // 存储bean定义的map
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    // 存储扫描后的所有后置处理器，在创建bean时执行后置的处理
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    // 解析Config类型上有那些Spring提供的注解, 扫描所有的Components
    public CustomApplicationContext(Class configClass) {
        this.configClass = configClass;
        scanComponents();
        initSingletonBean();
    }

    private void scanComponents() {
        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String pathScan = componentScan.value().replace(".", "/");
        // 拿到指定路径下加载的类型
        List<File> fileList = FileResourcesUtils.getClassFiles(pathScan);
        List<String> classNameList = FileResourcesUtils.getClassNamesFromFiles(fileList);
        for (String className: classNameList) {
            parseBeanDefinitions(className);
        }
    }

    // 解析类并生成BeanDefinition，根据bean的scope来确定创建bean对象的时机
    private void parseBeanDefinitions(String className) {
        try {
            // 扫描特定注解的类型, 注入指定的bean对象
            Class<?> clazz = CustomApplicationContext.class.getClassLoader().loadClass(className);
            if (clazz.isAnnotationPresent(Component.class)) {
                Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                String beanName = componentAnnotation.value();

                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setClazz(clazz);
                if (clazz.isAnnotationPresent(Scope.class)) {
                    Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                    beanDefinition.setScope(scopeAnnotation.value());
                } else {
                    beanDefinition.setScope("singleton");
                }
                beanDefinitionMap.put(beanName, beanDefinition);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void initSingletonBean() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet() ) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if (beanDefinition.getScope().equals("singleton")) {
               Object bean = createBean(beanName, beanDefinition);
               singletonObjects.put(beanName, bean);
            }
        }
    }

    // TODO. 根据bean定义来创建bean的对象并依赖注入
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        try {
            // 实例化: 通过Class反射(调用无餐构造器)得到一个bean的新对象
            Class clazz = beanDefinition.getClazz();
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 依赖注入: 给指定对象的指定属性赋值, 根据属性的名称来查找/创建
            for (Field declaredField: clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    Object filedInstance = getBean(declaredField.getName());
                    if (filedInstance == null) {
                        // 没有办法注入bean
                    }
                    declaredField.setAccessible(true);
                    declaredField.set(instance, filedInstance);
                }
            }

            // Aware回调: 回调特殊方法的实现(继承自特殊接口)
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            // Init初始化：调用初始化接口的实现
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // BeanPostProcessor: 后置处理器，对外提供的一种扩展机制

            return instance;
        } catch (Exception exception) {
            throw new RuntimeException("Failed to create bean object", exception);
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                return singletonObjects.get(beanName);
            } else if (beanDefinition.getScope().equals("prototype")) {
                // Create new instance for each time
                return createBean(beanName, beanDefinition);
            } else {
                throw new RuntimeException("Bean scope exception");
            }
        } else {
            throw new NullPointerException("Can not find the bean");
        }
    }
}
