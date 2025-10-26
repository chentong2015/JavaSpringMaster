package bean_import.selector_registrar;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector {

    // 通过完整路径(全类名路径)注入指定bean，支持批量注入
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // return new String[]{"bean.MyBean"};
        return new String[]{};
    }
}
