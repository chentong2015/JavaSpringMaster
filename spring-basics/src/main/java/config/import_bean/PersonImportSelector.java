package config.import_bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class PersonImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 通过完整路径(全类名路径)注入指定bean，支持批量注入
        return new String[]{"config.import_bean.Person"};
    }
}
