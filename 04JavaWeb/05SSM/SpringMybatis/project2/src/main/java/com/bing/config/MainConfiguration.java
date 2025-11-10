package com.bing.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration   // 配置类
@ComponentScan("com.bing")   // bean扫描范围
@MapperScan("com.bing.mapper")  // mapper扫描范围，spring会将mapper注册为bean
public class MainConfiguration {

    // 返回SqlSession模板
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws IOException {
        // 创建数据会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
        // 创建SqlSessionTemplate对象返回，将数据会话工厂作为参数传进去
        return new SqlSessionTemplate(factory);
    }
}
