package beans.bean_import;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 通过完整路径(全类名路径)注入指定bean，支持批量注入
        return new String[]{"beans.bean.MyBean"};
    }
}
