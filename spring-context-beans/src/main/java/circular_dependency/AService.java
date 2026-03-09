package circular_dependency;

import org.springframework.stereotype.Component;

@Component
public class AService {

    private final LazyInjection bService;

    public AService(LazyInjection bService) {
        this.bService = bService;
    }

    public void test() {
        System.out.println("test A Service");
    }
}
