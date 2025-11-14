package com.bing.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.bing.intercepter.MainInterceptor;
import com.bing.intercepter.SubInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

// SpringMvc配置类（处理Web的配置类）
@Configuration
@EnableWebMvc   // 开启SpringMvc注解
@ComponentScan("com.bing.controller")  // 指定控制器的扫描范围
public class SpringMvcConfig implements WebMvcConfigurer {

    //注册拦截器，在开发初始阶段，可以将拦截器的注册工作先注释掉，等核心功能开发完成后再打开注释
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册第一个拦截器
//        registry.addInterceptor(new MainInterceptor())
//                .addPathPatterns("/**")   //添加拦截器的匹配路径，这里表示拦截所有路径
//                .excludePathPatterns("/static/**","/login/**","/student/**");   //排除不进行拦截的路径
//
//        // 注册第二个拦截器
//        registry.addInterceptor(new SubInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/static/**","/login/**","/student/**");
//    }


    // 添加FastJSON转换器
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        // 由FastJSON转换器自动将我们返回的java对象转为json格式的字符串
//        converters.add(new FastJsonHttpMessageConverter());
//    }

    // 处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();   //开启默认的Servlet
    }
    // 添加一个响应处理器，处理静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }
}
