package properties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @ConditionalOnProperty 只有满足指定环境property属性设置才会注入配置中的beans
// matchIfMissing=true    即使属性条件不满足仍然match并注入
@Configuration
@ConditionalOnProperty(value = "isEnabled", havingValue = "true", matchIfMissing = false)
public class ConfigOnPropertyCondition {

    // -DisEnabled=true
    @Bean
    public MyConditionalBean myConditionalBean() {
        System.out.println("Inject conditional bean");
        return new MyConditionalBean();
    }

    class MyConditionalBean {
        private int id;
        private String name;

        public MyConditionalBean() {
        }

        public MyConditionalBean(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
