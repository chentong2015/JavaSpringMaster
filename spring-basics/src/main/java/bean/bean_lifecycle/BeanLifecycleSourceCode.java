package bean.bean_lifecycle;

// AbstractAutowireCapableBeanFactory.java
public class BeanLifecycleSourceCode {

    // 实际创建bean的方法
    // Object beanInstance = doCreateBean(beanName, mbdToUse, args);

    //  从doCreateBean()源码中分析出bean的生命周期
    //	protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
    //    	throws BeanCreationException {
    //		// Instantiate the bean.
    //		BeanWrapper instanceWrapper = null;
    //		if (mbd.isSingleton()) {
    //			instanceWrapper = this.factoryBeanInstanceCache.remove(beanName);
    //		}
    //		// 2. 实例化，创建bean实例 ==> 推断构造方法
    //		if (instanceWrapper == null) {
    //			instanceWrapper = createBeanInstance(beanName, mbd, args);
    //		}
    //		// 得到一个原始对象
    //		Object bean = instanceWrapper.getWrappedInstance();
    //		Class<?> beanType = instanceWrapper.getWrappedClass();
    //		if (beanType != NullBean.class) {
    //			mbd.resolvedTargetType = beanType;
    //		}
    //		// Allow post-processors to modify the merged bean definition.
    //		synchronized (mbd.postProcessingLock) {
    //			if (!mbd.postProcessed) {
    //				try {
    //					applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
    //				} catch (Throwable ex) {
    //					throw new BeanCreationException(mbd.getResourceDescription(), beanName,
    //					"Post-processing of merged bean definition failed", ex);
    //				}
    //				mbd.postProcessed = true;
    //			}
    //		}
    //
    //		// Eagerly cache singletons to be able to resolve circular references
    //		// even when triggered by lifecycle interfaces like BeanFactoryAware.
    //		// TODO: 如果当前创建的是单例bean，并且允许循环依赖，并且还在创建过程中
    //		// Set<String> singletonsCurrentlyInCreation
    //		boolean earlySingletonExposure = (mbd.isSingleton() &&
    //	     	this.allowCircularReferences && isSingletonCurrentlyInCreation(beanName));
    //		if (earlySingletonExposure) {
    //			if (logger.isTraceEnabled()) {
    //				logger.trace("Eagerly caching bean '" + beanName + "' to allow for resolving potential circular references");
    //			}
    //			// 使用lambda表达式来传递多个信息: beanName, bean definition, bean原始对象
    //			// TODO: 添加到三级缓存中 singletonFactories
    //             这里的lambda在被从三级缓存中取出来时，被执行，判断是否要执行AOP逻辑
    //			addSingletonFactory(beanName, () -> getEarlyBeanReference(beanName, mbd, bean));
    //		}
    //
    //		// Initialize the bean instance.
    //		Object exposedObject = bean;
    //		try {
    //			// TODO: @Autowired DI 依赖注入的完成, 给属性进行赋值
    //			populateBean(beanName, mbd, instanceWrapper);
    //
    //			// 调用后置处理器BeanPostProcessors初始化对象，对对象进行修改
    //			//   applyBeanPostProcessorsBeforeInitialization
    //			//   invokeInitMethods(beanName, wrappedBean, mbd);
    //			//   applyBeanPostProcessorsAfterInitialization
    //
    //          初始化原始对象
    //			exposedObject = initializeBean(beanName, exposedObject, mbd); // 生成代理对象
    //		} catch (Throwable ex) {
    //			if (ex instanceof BeanCreationException && beanName.equals(((BeanCreationException) ex).getBeanName())) {
    //				throw (BeanCreationException) ex;
    //			} else {
    //				throw new BeanCreationException(mbd.getResourceDescription(), beanName, "Initialization of bean failed", ex);
    //			}
    //		}
    //
    //		if (earlySingletonExposure) {
    //			Object earlySingletonReference = getSingleton(beanName, false);
    //			if (earlySingletonReference != null) {
    //				if (exposedObject == bean) {
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
    //		// Register bean as disposable.
    //		try {
    //			registerDisposableBeanIfNecessary(beanName, bean, mbd);
    //		} catch (BeanDefinitionValidationException ex) {
    //			throw new BeanCreationException(mbd.getResourceDescription(), beanName, "Invalid destruction signature", ex);
    //		}
    //		return exposedObject;
    //	}

    // lambda表达式执行的判断
    // protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
    //		if (StringUtils.hasLength(beanName) && this.targetSourcedBeans.contains(beanName)) {
    //			return bean;
    //		}
    //		if (Boolean.FALSE.equals(this.advisedBeans.get(cacheKey))) {
    //			return bean;
    //		}
    //		// 判断当前bean是否要进行AOP
    //		// 如果当前类型是PointCut, Advice, Advisor等就不需要进行AOP  ===> 切面不需要再进行AOP
    //		// 直接返回
    //		if (isInfrastructureClass(bean.getClass()) || shouldSkip(bean.getClass(), beanName)) {
    //			this.advisedBeans.put(cacheKey, Boolean.FALSE);
    //			return bean;
    //		}
    //		// Create proxy if we have advice.
    //		// 获取对应的beanClass所匹配的advisors, 根据bean.getClass()类找有没有对应的切面
    //		// TODO: Aspect注解解析出来的类型都是Advice
    //		Object[] specificInterceptors = getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);
    //		// 如果找到的Interceptor不为空，则要进行AOP
    //		if (specificInterceptors != DO_NOT_PROXY) {
    //			this.advisedBeans.put(cacheKey, Boolean.TRUE);
    //			// TODO: 创建一个代理对象，将找出来的Interceptor切面传递进去
    //			Object proxy = createProxy(bean.getClass(), beanName, specificInterceptors, new SingletonTargetSource(bean));
    //			this.proxyTypes.put(cacheKey, proxy.getClass());
    //			// 在返回创建好的代理对象
    //			return proxy;
    //	    }
    //		this.advisedBeans.put(cacheKey, Boolean.FALSE);
    //		// 没有创建AOP，返回原始对象
    //		return bean;
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
