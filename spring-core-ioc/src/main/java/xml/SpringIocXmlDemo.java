package xml;

import annotation.component.DemoComponent;
import annotation.config.MyDateSource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import xml.bean.BaseBean;

public class SpringIocXmlDemo {

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

    public static void main2(String[] args) {
        ConfigurableApplicationContext contextClassPath = new ClassPathXmlApplicationContext("beans.xml");

        // NumberGenerator numberGenerator = contextClassPath.getBean(NumberGenerator.class);
        // System.out.println(numberGenerator.nextRandomNumber());
        // NumberGenerator numberGenerator2 = contextClassPath.getBean("numberGenerator", NumberGenerator.class);
        // System.out.println(numberGenerator2.nextRandomNumber());

        // 测试依赖注入, 在构建对象时注入指定的bean
        // DependencyInjection dependencyInjection = contextClassPath.getBean(DependencyInjection.class);
        // dependencyInjection.testDependencyInjection();

        // 测试将bean作为Component, 在获取对象时使用默认bean id, 否则必须和自定义的id名称一致 !!
        DemoComponent demoComponent = contextClassPath.getBean(DemoComponent.class);
        demoComponent.testBeanAsComponent();

        // 测试从properties file中获取数据
        MyDateSource dateSource = contextClassPath.getBean("dataSource", MyDateSource.class);
        System.out.println(dateSource);

        // 关闭Spring Container, 其中的所有的bean将被销毁
        contextClassPath.close();
    }
}
