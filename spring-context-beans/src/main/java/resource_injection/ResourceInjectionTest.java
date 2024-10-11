package resource_injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import resource_injection.res.InjectionResourceFields;
import resource_injection.res.InjectionResourceSetter;

import java.util.List;

public class ResourceInjectionTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.register(ResourceInjectionConfig.class);
        appContext.refresh();

        InjectionResourceSetter resSetter = (InjectionResourceSetter) appContext.getBean("myResourceSetter");
        resSetter.testResourceInjection();

        InjectionResourceFields resFields = (InjectionResourceFields) appContext.getBean("myResourceFields");
        resFields.testResourceInjection();

        // 测试资源是否被修改
        List<String> listResource = (List<String>) appContext.getBean("myListResource");
        System.out.println(listResource.size());
        System.out.println(listResource.get(0));
    }
}
