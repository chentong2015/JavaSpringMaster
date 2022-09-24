package com.example.main;

import com.example.main.basebeans.BaseBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

// Spring IoC Container: Component of Spring framework, contains "Beans" and manage their lifecycle !!
// (Business Objects(POJOs) / Beans)
// (Configuration metadata) 读取metadata配置之后，POJOs会被加载到IoC Container ==> 推荐通过Annotation注解来实现 !!
// -> Spring Container 
// -> Configured system

// Eclipse Maven的配置: 
//由于耗时比较长，造成内存卡顿，使用手动添加dependency，而非使用搜索功能
//1. Preferences > Maven  > Download repository index updates on startup 设置启动时自动下载更新
//2. Windows > Show views > maven repository > Global Repositories > Full Index Enable/Rebuid Index
//3. POM.xml > Dependencies > Add > Search all dependencies 
public class BaseIoCContainer {

    // 1. 添加Spring Bean Configuration file: beans.xml

    public static void main(String[] args) {
        // ApplicationContext 代表着Spring IoC Container, 负责实例化，配置，组装beans

        // 1. 从文件系统获取配置文件: 项目目录文件夹
        // FileSystemXmlApplicationContext (IoC Container的实现) 最终继承自 ApplicationContext
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        BaseBean bean = (BaseBean) context.getBean("myBean");
        bean.testService();
        System.out.println(bean);
        context.close();

        // 2. 从ClassPath路径获取配置文件: /src/main/resources 默认的主路径
        // Project > new sources folder 创建到指定的位置
        // ClassPathXmlApplicationContext (IoC Container的实现) 最终继承自 ApplicationContext
    }

    private void testGetBeansFromClassPath() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-classpath.xml");
        BaseBean baseBean = (BaseBean) context.getBean("myBean");
        baseBean.testService();
        context.close();
    }

}
