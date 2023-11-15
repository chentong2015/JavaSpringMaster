package circular_dependency;

// TODO: Spring使用"三级缓存"来解决"循环依赖"的问题  ==> 扩展到死锁，相互依赖问题的解决
//  二三级缓存的目的是为了解决循环依赖，如果没有出现，则两个缓存其实没有起到实质性的作用
// 1. 单例池  singletonObjects: ConcurrentHashMap(256)
// 2. 二级缓存 earlySingletonObjects: ConcurrentHashMap(16)
// 3. 三级缓存 singletonFactories: HashMap(16)
// createSet<'beanName'>   判断是否正在创建
// earlyProxyReference Map 判断是否提前进行AOP，执行过lambda表达式
public class CircularDependency {

    // 二级缓存的基础逻辑:
    // A a = new A();
    // B b = new B();
    // b.a = a;   这里的a对象虽然不"完整", 但是经过下一步之后a对象会变成完整的
    // a.b = b;   最终创建出来的对象的属性都是有值的 !!

    // 如何判断AService出现了循环依赖? 以至于需要提前AOP
    // creatingSet<'aService'> 表示正在创建的bean
    // 如果在其他的bean的创建过程中，使用到了这个正在创建的bean(在set中)，那么就是一种循环依赖，则提前AOP
    // creatingSet.remove('aService')

    // DefaultSingletonBeanRegistry.java
    //  一级缓存
    //	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
    //	二级缓存 & 三级缓存: 同时使用，一个添加，一个必然减少
    //  TODO: 两个操作必须保证原子性，加锁
    //	private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(16);
    //	private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);
    //
    //  TODO: 拿到Singleton单例，通过bean名称获取一个单例
    //  allowEarlyReference标记知否需要从三级缓存中找，根据bean生命周期中的步骤来确定
    //	protected Object getSingleton(String beanName, boolean allowEarlyReference) {
    //		// 1. 首先从singletonObjects单例缓存池(一级缓存)中找bean
    //		Object singletonObject = this.singletonObjects.get(beanName);
    //      // 2. 如果没有找到，同时这个bean又正在创建的过程中，则说明出现了循环依赖
    //		if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
    //			// 3. 从二级缓存中找
    //			singletonObject = this.earlySingletonObjects.get(beanName);
    //			// 4. 如果二级缓存中没有找到，则对一级缓存进行同步化
    //			if (singletonObject == null && allowEarlyReference) {
    //				// TODO: 这里添加同步锁，并且使用Double Check放置在这个过程中，一级缓存中是没有bean的(可能被别的线程添加)
    //                       加锁同时保证二三级缓存中的添加和移除操作是原子性的 !! 所以使用HashMap便可以支持
    //				// 这里的一级缓存使用的是ConcurrentHashMap
    //				synchronized (this.singletonObjects) {
    //					singletonObject = this.singletonObjects.get(beanName);
    //					if (singletonObject == null) {
    //                      // 5. 双检判断之后，再次从二级缓存中取bean
    //						singletonObject = this.earlySingletonObjects.get(beanName);
    //						if (singletonObject == null) {
    //						    // 6. 最后再从三级缓存中取出lambda表达式来执行
    //							ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
    //							if (singletonFactory != null) {
    //								singletonObject = singletonFactory.getObject();
    //								// 7. 最后将执行生成的bean对象，放置到二级缓存中
    //								this.earlySingletonObjects.put(beanName, singletonObject);
    //								// 8. 移除三级缓存中已经有的
    //		         				//    lambda表达式已经执行过了，如果需要AOP，则会被执行两次 !!
    //		                		//    之后可以直接从二级缓存中取bean对象
    //								this.singletonFactories.remove(beanName);
    //							}
    //						}
    //					}
    //				}
    //			}
    //		}
    //		return singletonObject;
    //	}
}
