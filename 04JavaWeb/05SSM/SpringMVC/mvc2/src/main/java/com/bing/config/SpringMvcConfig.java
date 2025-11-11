package com.bing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// SpringMvc配置类（处理Web的配置类）
@Configuration
@EnableWebMvc   // 开启SpringMvc注解
@ComponentScan("com.bing.controller")  // 指定控制器的扫描范围
public class SpringMvcConfig {
}
