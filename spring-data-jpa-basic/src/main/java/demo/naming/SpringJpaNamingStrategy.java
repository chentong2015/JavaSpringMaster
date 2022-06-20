package demo.naming;

import javax.validation.constraints.NotNull;

// TODO. Hibernate JPA在table和column的命名策略
// 1. 如果没有注明，则默认根据属性的名称进行下划线的分开
//    table中的名称是lower case, 会转换映射到"session_name"列名称上
// 2. 自定义
//    @Column(name = "component_id", nullable = false) 使用注解修改
//    spring.jpa.hibernate.naming.physical-strategy    属性配置成驼峰形式来完成映射
//      =org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
public class SpringJpaNamingStrategy {
    
    @NotNull
    private String sessionName;
}
