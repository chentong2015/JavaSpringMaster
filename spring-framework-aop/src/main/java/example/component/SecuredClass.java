package example.component;

import example.model.Secured;
import org.springframework.stereotype.Component;

@Component
public class SecuredClass {

    @Secured(isLocked = true)
    public void lockedMethod() {
        System.out.println("call lockedMethod");
    }

    @Secured(isLocked = false)
    public void unlockedMethod() {
        System.out.println("call unlockedMethod");
    }
}
