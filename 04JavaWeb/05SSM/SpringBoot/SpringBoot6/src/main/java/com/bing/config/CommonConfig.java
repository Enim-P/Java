package com.bing.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration   // 添加了@Configuration注解的类，才是配置类
public class CommonConfig {

    // 管理第三方资源的Bean
    @Bean
    public SAXReader saxReader(){
        return new SAXReader();
    }

}
