package annotation.lifecycle;

import annotation.qualifier.GuessCount;
import annotation.qualifier.MaxNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

/**
 * Bean对象构建的lifecycle生命周期
 * 1. 配置beans.xml : 约束了所有的方法名称，同时保证必须提供
 * .  default-init-method="reset", default-destroy-method="clean" 默认所有bean在初始化时和销毁时调用方法
 * 2. 配置bean注入   : 约束了名称，必须提供相同的名称
 * .  <bean id="id" class="main.model.Class" init-method="init" destroy-method="clean">
 * 3. 注解Annotation: 使用Java Annotation API注解标记生命周期，在对象初始化时和销毁前调用的方法  ===> 推荐 !!
 * .  添加依赖 javax.annotation dependency / 添加注解到方法 @PostConstruct  @PreDestroy
 */
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // @Autowired
    // @MaxNumber
    private final int maxNumber;
    private final int guessCount;

    /**
     * 强烈建议使用 Constructor Inject
     * 1. 将filed声明成final, 通过构造器注入(初始化)，创建Immutable class
     * 2. 当且仅当target bean只有一个构造器的时候，这里的@Autowired可以不必添加 !!! 当有多个构造器时，必须注明其中一个
     */
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @GuessCount int guessCount) {
        this.maxNumber = maxNumber;
        this.guessCount = guessCount;
    }

    /**
     * @PostConstruct when all the beans are loaded, initialized
     */
    @PostConstruct
    public void init() {
        System.out.println("Init generator object");
        System.out.println("Max = " + maxNumber + ", guess = " + guessCount);
    }

    @Override
    public int nextRandomNumber() {
        return new Random().nextInt(10);
    }

    /**
     * @PreDestroy 当实例从Spring Container容器中移除的时候，调用的方法
     * PreDestroy annotation is used on methods to signal that
     * the instance is in the process of being removed by the container
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre destroy generator object");
    }
}
