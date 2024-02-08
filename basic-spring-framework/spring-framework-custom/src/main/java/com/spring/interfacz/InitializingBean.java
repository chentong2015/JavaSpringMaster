package com.spring.interfacz;

// 在完成Bean的属性设置之后要调用的初始化
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
