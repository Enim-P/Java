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
                // 放行index.html及根路径（/会自动映射到index.html）
                .excludePathPatterns(
                        "/index.html", // 放行/index.html路径
                        "/"            // 放行根路径（默认指向index.html）
                )
                .excludePathPatterns("/admins/login","/admins/register")  //排除指定的资源
                .excludePathPatterns(
                        "/doc.html",
                        "/swagger-resources/**",
                        "/v2/api-docs",
                        "/v3/api-docs",
                        "/webjars/**",
                        "/swagger-ui.html"
                )   // 排除掉swagger相关的请求资源
                .excludePathPatterns(
                        "/static/**",    // 放行classpath:/static/下的资源
                        "/public/**",    // 放行classpath:/public/下的资源
                        "/resources/**", // 放行classpath:/resources/下的资源
                        "/META-INF/resources/**", // 放行classpath:/META-INF/resources/下的资源
                        "/favicon.ico"   // 放行/favicon.ico（网站图标）
                );  // 排除静态资源路径（匹配默认静态资源目录下的所有资源）
    }
}
