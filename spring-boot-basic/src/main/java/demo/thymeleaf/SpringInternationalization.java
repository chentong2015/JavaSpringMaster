package demo.thymeleaf;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * TODO: 监测当地语言和使用者的IP地址来设置对应的语言环境
 * Spring Thymeleaf 国际化(i18n)的设置
 * 1. 取消硬编码，支持多语言的UI显示以及后台的字符串messages
 * 2. 通过配置文件设置，不需要重新编译，而是动态的获取
 */
@Component
public class SpringInternationalization implements ISpringInternationalization {

    /**
     * 默认的messages file位于/src/main/resources/
     * - messages.properties    默认的语言locale
     * - messages_XX.properties 特定的语言local
     * Thymeleaf支持通过#{localText}来获取指定的local text ===> 直接从前端提取信息
     */

    /**
     * application.properties 添加支持多语言的设置
     * spring.mvc.local=fr               设置默认使用的local语言
     * spring.web.locale-resolver=fixed  use fixed local resolved class 返回设置的固定的local语言, 反之会根据页面header"Accept-Language"来解析
     */

    /**
     * 设置整个项目的编码格式
     * File > Settings > Editor > File Encoding > Project Encoding
     * 设置properties配置文件的默认编码格式，以便解析不同的语言
     * File > Settings > Editor > File Encoding > Default encoding for properties files > UTF-8 / GBK支持中文注释
     */

    private final MessageSource messageSource;

    public SpringInternationalization(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // 具体背后的逻辑, 放置在属于它的职责类型中
    // Compound Message 其中包含多个变量的message, {0} {1}其中的数字表示参数的index !!
    public String getGameMessage() {
        String key = "gameMessage";
        int smallestNum = 1;
        int biggestNum = 100;
        return getPropertyMessage(key, smallestNum, biggestNum);
    }

    /**
     * MessageSource接口: 用于从messages properties file获取messages, 然后完成替换
     * 1. 支持i18n, 属于Spring Framework的一部分, 可以通过构造器注入到@Component中 (自动完成注入) !!
     * 2. getLocale() 获取当前正在使用的语言locale, 从指定的properties file中获取
     */
    private String getPropertyMessage(String key, Object... args) {
        // LocaleContextHolder is the central for the current locale in Spring
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}










