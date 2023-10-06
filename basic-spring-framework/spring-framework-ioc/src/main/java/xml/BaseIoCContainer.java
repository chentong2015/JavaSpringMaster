package xml;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseIoCContainer {

    // 添加Spring Bean Configuration file: beans.xml
    // ApplicationContext 代表着Spring IoC Container, 负责实例化，配置，组装beans
    public static void main(String[] args) {
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
}
