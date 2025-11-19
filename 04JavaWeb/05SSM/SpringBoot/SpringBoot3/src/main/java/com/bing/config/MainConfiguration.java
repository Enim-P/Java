package com.bing.config;

import com.two.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 添加一个配置类
@Configuration
@ComponentScan("com.one")   //设置bean扫描的范围
public class MainConfiguration {

    // 手动注册bean对象
    @Bean
    public Teacher teacher(){
        return new Teacher();
    }

}
