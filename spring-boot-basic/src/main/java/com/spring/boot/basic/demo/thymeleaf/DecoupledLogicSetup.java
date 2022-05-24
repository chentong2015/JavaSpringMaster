package com.spring.boot.basic.demo.thymeleaf;

import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Component
public class DecoupledLogicSetup {

    private final SpringResourceTemplateResolver templateResolver;

    // Enable the decoupled template logic
    // setUseDecoupledLogic() 这里设置的属性或可通过application.properties来设置
    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
        this.templateResolver.setUseDecoupledLogic(true);
    }
}
