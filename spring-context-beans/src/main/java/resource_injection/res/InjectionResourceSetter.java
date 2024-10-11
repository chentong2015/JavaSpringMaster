package resource_injection.res;

import javax.annotation.Resource;
import java.util.List;

public class InjectionResourceSetter {

    private List<String> stringList;

    @Resource(name = "myListResource")
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void testResourceInjection() {
        this.stringList.add("item 2");
        System.out.println("Add item 2 ok");
    }
}
