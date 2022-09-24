package bean.component;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.ctong.tomcat:type=statistics,name=count")
public class BaseComponentManaged {

    @ManagedAttribute(description = "The current user instance.")
    public User getUser() {
        return new User();
    }
}
