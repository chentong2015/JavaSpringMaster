package bean_import;

import bean.MyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeansImportApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(SpringBeansConfiguration.class);
        appContext.refresh(); // 必须Refresh才能Active
        System.out.println(appContext.isActive());

        MyBean myBean = (MyBean) appContext.getBean("old-bean");
        myBean.print("old-bean");

        MyBean newBean = (MyBean) appContext.getBean("new-bean");
        myBean.print("new-bean");

        MyBean fullBean = (MyBean) appContext.getBean("full-bean");
        myBean.print("full-bean");

        // 关闭Spring IOC容器并销毁注入bean对象
        appContext.close();
    }
}
