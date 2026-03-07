package circular_dependency;

import org.springframework.stereotype.Component;

@Component
public class AService {

    private final LazyBService bService;

    public AService(LazyBService bService) {
        this.bService = bService;
    }

    public void test() {
        System.out.println("test A Service");
    }
}
