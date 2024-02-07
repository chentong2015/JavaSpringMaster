package com.spring;

import com.spring.util.FileResourcesUtils;

import java.io.File;
import java.util.List;

// 自定义的Spring Context容器类
public class CustomApplicationContext {

    private Class configClass;

    // 解析Config类型上有那些Spring提供的注解 @ComponentScan -> path -> scan
    public CustomApplicationContext(Class configClass) {
        this.configClass = configClass;
        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String pathScan = componentScan.value();
        System.out.println(pathScan);

        // 拿到加载当前项目类型的ClassLoader，也即Application ClassLoader
        ClassLoader classLoader = CustomApplicationContext.class.getClassLoader();
        // 拿到指定路径下加载的类型
        List<File> fileList = FileResourcesUtils.getClassFiles(classLoader, "main/service");
        List<String> classNameList = FileResourcesUtils.getClassNamesFromFiles(fileList);
        for (String className: classNameList) {
            try {
                // 扫描满足特定注解的类型
                Class<?> clazz = classLoader.loadClass(className);
                if (clazz.isAnnotationPresent(Component.class)) {
                    System.out.println(className);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public Object getBean(String beanName) {
        return null;
    }
}
