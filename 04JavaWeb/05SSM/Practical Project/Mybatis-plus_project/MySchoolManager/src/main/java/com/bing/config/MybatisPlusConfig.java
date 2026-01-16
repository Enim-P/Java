package com.bing.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    // 定义MybatisPlus的拦截器
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        // 创建MybatisPlus拦截器
        MybatisPlusInterceptor myInterceptor = new MybatisPlusInterceptor();
        // 1.添加分页拦截器
        myInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 2.添加乐观锁拦截器（在更新数据时会自动加锁）
        // myInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return myInterceptor;
    }
}
