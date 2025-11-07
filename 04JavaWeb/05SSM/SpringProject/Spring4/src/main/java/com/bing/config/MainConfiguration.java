package com.bing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 定义Spring的配置类
@Configuration
@ComponentScan("com.bing")   //扫描bean的范围
@EnableAspectJAutoProxy   // 开启AOP注解支持
public class MainConfiguration {
}
