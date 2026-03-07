package resource_injection.bean;

import javax.annotation.Resource;
import java.util.List;

public class InjectionResourceFields {

    // TODO. 使用@Resource从IoC中获取Bean对象
    // - 查找特定bean name名称的bean对象
    // - 判断primary type match类型匹配
    @Resource(name = "myListResource")
    private List<String> stringList;

    public InjectionResourceFields() {
    }

    public void testResourceInjection() {
        this.stringList.add("item 1");
        System.out.println("Add item 1 ok");
    }
}
