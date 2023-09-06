package bean.bean_lifecycle;

// AbstractAutowireCapableBeanFactory.java
public class BeanLifecycleSourceCode {

    // 实际创建bean的方法
    // Object beanInstance = doCreateBean(beanName, mbdToUse, args);

    //  从doCreateBean()源码中分析出bean的生命周期
    //	protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
    //    	throws BeanCreationException {
    //		// Instantiate the spring_framework.bean.
    //		BeanWrapper instanceWrapper = null;
    //		if (mbd.isSingleton()) {
    //			instanceWrapper = this.factoryBeanInstanceCache.remove(beanName);
    //		}
    //		// 2. 实例化，创建bean实例 ==> 推断构造方法
    //		if (instanceWrapper == null) {
    //			instanceWrapper = createBeanInstance(beanName, mbd, args);
    //		}
    //		// 得到一个原始对象
    //		Object spring_framework.bean = instanceWrapper.getWrappedInstance();
    //		Class<?> beanType = instanceWrapper.getWrappedClass();
    //		if (beanType != NullBean.class) {
    //			mbd.resolvedTargetType = beanType;
    //		}
    //		// Allow post-processors to modify the merged spring_framework.bean definition.
    //		synchronized (mbd.postProcessingLock) {
    //			if (!mbd.postProcessed) {
    //				try {
    //					applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
    //				} catch (Throwable ex) {
    //					throw new BeanCreationException(mbd.getResourceDescription(), beanName,
    //					"Post-processing of merged spring_framework.bean definition failed", ex);
    //				}
    //				mbd.postProcessed = true;
    //			}
    //		}
    //
    //		// Eagerly cache singletons to be able to resolve circular references
    //		// even when triggered by lifecycle interfaces like BeanFactoryAware.
    //		// TODO: 如果当前创建的是单例bean，并且允许循环依赖，并且还在创建过程中
    //		// Set<String> singletonsCurrentlyInCreation 基本都是true的
    //		boolean earlySingletonExposure = (mbd.isSingleton() &&
    //	     	this.allowCircularReferences && isSingletonCurrentlyInCreation(beanName));
    //		if (earlySingletonExposure) {
    //			if (logger.isTraceEnabled()) {
    //				logger.trace("Eagerly caching spring_framework.bean '" + beanName + "' to allow for resolving potential circular references");
    //			}
    //			// 使用lambda表达式来传递多个信息: beanName, spring_framework.bean definition, bean原始对象
    //			// TODO: 添加到三级缓存中 singletonFactories
    //             这里的lambda在被从三级缓存中取出来时，被执行，判断是否要执行AOP逻辑
    //			addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, spring_framework.bean));
    //		}
    //
    //		// Initialize the spring_framework.bean instance.
    //		Object exposedObject = spring_framework.bean;
    //		try {
    //			TODO: 填充属性@Autowired DI 依赖注入的完成, 给属性进行赋值
    //			populateBean(beanName, mbd, instanceWrapper);
    //		    TODO: 初始化和BeanPostProcessor 正常AOP
    //			exposedObject = initializeBean(beanName, exposedObject, mbd); // 生成代理对象
    //		} catch (Throwable ex) {
    //			if (ex instanceof BeanCreationException && beanName.equals(((BeanCreationException) ex).getBeanName())) {
    //				throw (BeanCreationException) ex;
    //			} else {
    //				throw new BeanCreationException(mbd.getResourceDescription(), beanName, "Initialization of spring_framework.bean failed", ex);
    //			}
    //		}
    //		if (earlySingletonExposure) {
    //          TODO: 对应缓存解法的第4.5步逻辑
    //                在解决循环依赖时，当AService的属性注入完成之后，从getSingleton中得到AService AOP之后代理对象
    //			Object earlySingletonReference = getSingleton(beanName, false);
    //			if (earlySingletonReference != null) {
    //              如果提前暴露的对象和经过了完整生命周期之后的对象相等，则把代理对象赋值给exposedObject
    //              最终会添加到singletonObjects中去
    //				if (exposedObject == spring_framework.bean) {
    //					exposedObject = earlySingletonReference;
    //				} else if (!this.allowRawInjectionDespiteWrapping && hasDependentBean(beanName)) {
    //					String[] dependentBeans = getDependentBeans(beanName);
    //					Set<String> actualDependentBeans = new LinkedHashSet<>(dependentBeans.length);
    //					for (String dependentBean : dependentBeans) {
    //						if (!removeSingletonIfCreatedForTypeCheckOnly(dependentBean)) {
    //							actualDependentBeans.add(dependentBean);
    //						}
    //					}
    //					if (!actualDependentBeans.isEmpty()) {
    //						throw new BeanCurrentlyInCreationException(beanName,...);
    //				}
    //			}
    //		}
    //		// Register spring_framework.bean as disposable.
    //		try {
    //			registerDisposableBeanIfNecessary(beanName, spring_framework.bean, mbd);
    //		} catch (BeanDefinitionValidationException ex) {
    //			throw new BeanCreationException(mbd.getResourceDescription(), beanName, "Invalid destruction signature", ex);
    //		}
    //		return exposedObject;
    //	}

    // 在填充属性完成之后，关于初始化的代码
    // protected Object initializeBean(String beanName, Object spring_framework.bean, @Nullable RootBeanDefinition mbd) {
    //		// 执行aware
    //		invokeAwareMethods(beanName, spring_framework.bean);
    //		Object wrappedBean = spring_framework.bean;
    //		if (mbd == null || !mbd.isSynthetic()) {
    //			// 4.2 初始化前
    //			wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
    //		}
    //		try {
    //			// 4.3 初始化
    //			invokeInitMethods(beanName, wrappedBean, mbd);
    //		} catch (Throwable ex) {
    //			throw new BeanCreationException((mbd != null ? mbd.getResourceDescription() : null), beanName, "Invocation of init method failed", ex);
    //		}
    //		if (mbd == null || !mbd.isSynthetic()) {
    //			// 4.4 初始化后
    //          TODO: 在初始化后会判断当前正在创建的bean是否需要进行AOP, 最终会执行到下面的方法
    //                其中需要判断是否"还需要执行AOP"
    //			wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
    //		}
    //		return wrappedBean;
    //	}

    // 上面4.4步初始化后调用的方法 >> 正常进行AOP的地方
    // TODO: 这个时候将@Before(value = "pointCut()")解析出来，放到缓存 !!
    // public Object postProcessAfterInitialization(@Nullable Object spring_framework.bean, String beanName) {
    //     if (spring_framework.bean != null) {
    //         Object cacheKey = getCacheKey(spring_framework.bean.getClass(), beanName);
    //         // earlyProxyReference存储的是那些提前进行了AOP的bean, beanName: AOP之前的对象
    //         // 判断如果没有提前进行AOP, 则进行AOP
    //         if (this.earlyProxyReferences.remove(cacheKey) != spring_framework.bean) { // 如果执行过，则不进入if条件
    //             return wrapIfNecessary(spring_framework.bean, beanName, cacheKey);
    //         }
    //     }
    //     // 直接返回原始对象
    //     // 最终如果有AOP之后的代理对象，则后面4.5步会中二级缓存中取拿到"代理对象"
    //     return spring_framework.bean;
    // }

    // TODO: 执行lambda表达式的过程中会调用的方法 >> 提前AOP
    // 如果没有提前进行过AOP, 则进行AOP
    // protected Object wrapIfNecessary(Object spring_framework.bean, String beanName, Object cacheKey) {
    //		if (StringUtils.hasLength(beanName) && this.targetSourcedBeans.contains(beanName)) {
    //			return spring_framework.bean;
    //		}
    //		if (Boolean.FALSE.equals(this.advisedBeans.get(cacheKey))) {
    //			return spring_framework.bean;
    //		}
    //		// 判断当前bean是否要进行AOP
    //		// 如果当前类型是PointCut, Advice, Advisor等就不需要进行AOP  ===> 切面不需要再进行AOP
    //		// 直接返回
    //		if (isInfrastructureClass(spring_framework.bean.getClass()) || shouldSkip(spring_framework.bean.getClass(), beanName)) {
    //			this.advisedBeans.put(cacheKey, Boolean.FALSE);
    //			return spring_framework.bean;
    //		}
    //		// Create proxy if we have advice.
    //		// 获取对应的beanClass所匹配的advisors, 根据bean.getClass()类找有没有对应的切面
    //		// TODO: Aspect注解解析出来的类型都是Advice
    //		Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(spring_framework.bean.getClass(), beanName, null);
    //		// 如果找到的Interceptor不为空，则要进行AOP
    //		if (specificInterceptors != DO_NOT_PROXY) {
    //			this.advisedBeans.put(cacheKey, Boolean.TRUE);
    //			// TODO: 创建一个代理对象，将找出来的Interceptor切面传递进去
    //			Object proxy = createProxy(spring_framework.bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(spring_framework.bean));
    //			this.proxyTypes.put(cacheKey, proxy.getClass());
    //			// 在返回创建好的代理对象
    //			return proxy;
    //	    }
    //		this.advisedBeans.put(cacheKey, Boolean.FALSE);
    //		// 没有创建AOP，返回原始对象
    //		return spring_framework.bean;
    //	}

    //	TODO: 当bean创建完成后，添加到单例缓存池中(一级缓存中)，同时移除创建过程中添加的二级和三级缓存中的数据
    // protected void addSingleton(String beanName, Object singletonObject) {
    //		synchronized (this.singletonObjects) {
    // 			this.singletonObjects.put(beanName, singletonObject);
    //			this.singletonFactories.remove(beanName);
    //			this.earlySingletonObjects.remove(beanName);
    //			// 记录保存已经处理的bean
    //			this.registeredSingletons.add(beanName);
    //		}
    //	}
}
