package com.bing.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration   // 配置类
@EnableTransactionManagement  // 开启事务管理
@ComponentScan("com.bing")   // bean扫描范围
@MapperScan("com.bing.mapper")  // mapper扫描范围，spring会将mapper注册为bean
public class MainConfiguration {

    // 数据源
    @Bean
    public DataSource dataSource(){
        // 创建并返回一个具体的数据源对象
        return new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/myschool",
                "root",
                "root1234");
    }

    // 数据会话工厂
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean;
    }

    // 事务管理
    @Bean
    public TransactionManager transactionManager(@Autowired DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
