package bean_import;

import bean_import.model.MyBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(value = {MyBean.class, CustomBeanDefinitionRegister.class, CustomImportSelector.class})
@Configuration
public class ImportBeanConfiguration {
}
