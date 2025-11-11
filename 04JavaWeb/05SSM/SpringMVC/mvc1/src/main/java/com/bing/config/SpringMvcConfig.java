package com.bing.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// SpringMvc配置类
@Configuration
@EnableWebMvc   // 开启SpringMvc注解
@ComponentScan("com.bing.controller")
public class SpringMvcConfig {
}
