package com.bing.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration   // 配置类
@ComponentScan("com.bing")      // bean扫描范围
@MapperScan("com.bing.mapper")  // mapper扫描范围，spring会将mapper注册为bean
public class NoXmlConfiguration {

    // 注册一个数据源bean对象
    // 这里返回的DataSource接口是连接池，创建PooledDataSource就是一个具体的连接池对象
    // 什么是连接池？
    // 连接池里面存放的是数据库连接对象，在连接池里面会提前创建很多个连接对象，当需要访问数据库的时候，
    // 从连接池里面返回一个连接对象，连接数据库，操作数据库。
    // 所以，连接池是优化数据库连接的。
    /*@Bean
    public DataSource dataSource(){
        // 创建并返回一个具体的数据源对象
        return new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/myschool",
                "root",
                "root1234");
    }*/

    // 这里返回的是HikariPC连接池，springboot中默认的连接池
    @Bean
    public DataSource dataSource(){
        // HikariPC连接池的内部使用了SLF4J日志框架打印日志信息，
        // 如果当前项目没有安装SLF4J日志框架依赖的话，在控制台会提升错误
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/myschool");
        dataSource.setUsername("root");
        dataSource.setPassword("root1234");
        return dataSource;
    }

    // 返回数据会话工厂Bean对象
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DataSource dataSource){
        // 创建数据会话工厂Bean对象
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // 设置数据源（数据源就是连接池）
        bean.setDataSource(dataSource);
        // 返回数据会话工厂Bean对象
        return bean;
    }
}
