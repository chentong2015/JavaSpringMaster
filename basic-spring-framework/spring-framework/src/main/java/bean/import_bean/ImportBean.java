package bean.import_bean;

import bean.import_bean.model.MyBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(value = {MyBean.class, PersonBeanDefinitionRegister.class, PersonImportSelector.class})
@Configuration
public class ImportBean {

}
