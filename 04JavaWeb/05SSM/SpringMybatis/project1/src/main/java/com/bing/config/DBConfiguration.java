package com.bing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration   // 它是配置类
public class DBConfiguration {
    // 比如：在这个配置类中管理数据库相关的bean

    // 管理数据库连接对象
    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myschool",
                "root",
                "root1234");
    }
}
