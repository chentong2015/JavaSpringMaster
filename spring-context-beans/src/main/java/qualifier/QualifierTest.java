package qualifier;

import org.springframework.beans.factory.annotation.Autowired;

public class QualifierTest {

    // 指定Qualifier Annotation来注入特定的Bean对象
    @Autowired
    @MaxNumber
    private int maxNumber;
}
