package resource_injection.res;

import javax.annotation.Resource;
import java.util.List;

public class InjectionResourceFields {

    @Resource(name = "myListResource")
    private List<String> stringList;

    public InjectionResourceFields() {
    }

    public void testResourceInjection() {
        this.stringList.add("item 1");
        System.out.println("Add item 1 ok");
    }
}
