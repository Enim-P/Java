package com.bing.config;

import com.bing.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Web配置类
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 注入登录校验拦截器对象
    @Resource
    LoginInterceptor loginInterceptor;


    // 注册拦截器的方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册登录校验拦截
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")  //拦截所有资源
                .excludePathPatterns("/admins/login","/admins/register");  //排除指定的资源
    }
}
