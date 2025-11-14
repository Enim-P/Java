package com.bing.config;

import com.bing.bean.Car;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

// Spring配置类（处理非Web的配置类，比如注册Mybatis等等）
@Configuration
@EnableTransactionManagement  // 开启事务管理
@ComponentScan("com.bing")   // bean扫描范围
@MapperScan("com.bing.mapper")  // mapper扫描范围，spring会将mapper注册为bean
public class SpringConfig {

    // 注册commonsMultipartResolver文件上传解析器
    // 注意：这里Bean的名称是固定的，必须是multipartResolver
    @Bean("multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(1024*1024*10);   //最大上传文件大小为10MB
        resolver.setDefaultEncoding("UTF-8");      //设置默认编码格式
        return resolver;
    }

    // Bean的Web作用域
    @Bean
    //@RequestScope   //request作用域Bean，每次发送请求时，创建Bean对象
    @SessionScope     //session作用域Bean，每一个会话创建一个Bean对象
    public Car car(){
        return new Car();
    }

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
