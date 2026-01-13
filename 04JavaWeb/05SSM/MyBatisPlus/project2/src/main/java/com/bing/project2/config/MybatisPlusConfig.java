package com.bing.project2.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    // 定义MybatisPlus的拦截器
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor myInterceptor = new MybatisPlusInterceptor();
        // 添加分页拦截器
        myInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return myInterceptor;
    }
}
