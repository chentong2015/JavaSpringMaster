package xml;

import xml.bean.MyDateSource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import xml.bean.BaseBean;

// Spring Bean Configuration file: beans.xml
public class SpringIocXmlDemo {

    public static void main(String[] args) {
        // TODO. 从文件系统获取配置文件: 项目目录文件夹
        // FileSystemXmlApplicationContext (IoC Container的实现) 最终继承自 ApplicationContext
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        BaseBean bean = (BaseBean) context.getBean("myBean");
        bean.testService();
        context.close();

        // TODO. 从ClassPath路径获取配置文件: /src/main/resources 默认的主路径
        ConfigurableApplicationContext contextClassPath = new ClassPathXmlApplicationContext("beans.xml");

        // 根据类型直接指定对象Bean
        BaseBean baseBean = contextClassPath.getBean(BaseBean.class);
        baseBean.testService();
        // 根据Bean的类型和名称获取bean object
        MyDateSource dateSource = contextClassPath.getBean("dataSource", MyDateSource.class);

        // 关闭Spring Container, 销毁所有的bean
        contextClassPath.close();
    }
}
