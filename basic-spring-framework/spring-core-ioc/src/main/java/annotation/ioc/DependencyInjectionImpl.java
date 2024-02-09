package annotation.ioc;

import annotation.lifecycle.NumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class DependencyInjectionImpl implements DependencyInjection {

    /**
     * 1. Field based dependency injection
     * > Autowiring Beans：Spring Container auto-inject and set the field !!  ===> 推荐使用 !! 同样适用在Constructor & Setter
     * > 添加注解, Container会自动从beans中获取bean, 并实现注入到instance variable
     * > Autowiring by type from name 'dependencyInjection' to bean named 'numberGenerator'
     */
    @Autowired
    // Note: 这里的自动注入必须保持唯一性, 当Container中的bean不唯一时, container无法找到正确的注入
    // Note: 如果使用bean method则应该保持变量名称和方法名称一致, 才能完成正确的注入
    // Solution: 使用qualifiers annotation来解决指定注入的问题 !!!
    private NumberGenerator generator;

    @Override
    public void testDependencyInjection() {
        int number = generator.nextRandomNumber();
        System.out.println("Get number = " + number);
    }

    /**
     * 2. Constructor based dependency injection
     * ===> 一般使用在强制的依赖，创建对象时必须注入的参数: 保证对象的不可变性 + 所需的依赖不为空 !!
     * > 通过构造器来依赖注入指定的interface, 实现解耦
     * > 配置beans.xml的<constructor-arg ref="referenceToBean" /> 传递构造器的参数argument, referenceToBean表示对bean的引用
     */
    // Note：构造器器一般最多传入3个参数，不可注入过多
    // Note: 过多的参数意味着类的职责过多，违反面向对象的原则，需要重构
    /* public DependencyInjectionImpl(NumberGenerator numberGenerator) {
        this.generator = numberGenerator;
    } */

    /**
     * 3. Setter based dependency injection
     * ===> 一般用在可选的依赖, 非必须的注入, 所需要注入的一般拥有默认值 !!
     * > 通过setter来实现依赖注入interface, 实现解耦
     * > 配置beans.xml的<property name="fieldName" ref="referenceToBean" />
     */
    // Note: reconfiguration or re-injection 允许在后期重新配置和重新注入
    // Note: Circular Dependencies 可以解决循环依赖的问题, 避免无法构造出对象, 逻辑上面有创建对象的"优先级"
    /* public void setGenerator(NumberGenerator numberGenerator) {
        this.generator = numberGenerator;
    } */
}
