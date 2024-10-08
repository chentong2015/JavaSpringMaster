package beans_qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class QualifierTest {

    // 指定Qualifier Annotation来注入特定的Bean对象
    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    public void testCount(@Qualifier("guessCount") int count) {
        System.out.println(count);
    }
}
