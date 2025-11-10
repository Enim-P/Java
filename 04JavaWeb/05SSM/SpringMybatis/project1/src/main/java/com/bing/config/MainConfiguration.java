package com.bing.config;

import com.bing.util.Teacher;
import org.springframework.context.annotation.*;

import java.util.Date;

// 配置类
@Configuration   // 添加该注解的类都是配置类
@Import(DBConfiguration.class)   // 将某个类导入到容器中，通常用于导入其他配置类
@ComponentScan("com.bing.pojo")   // 扫描bean，将指定的包里面的类注册为spring管理的bean
@EnableAspectJAutoProxy   // 开启AOP注解开发
public class MainConfiguration {

    // 手动定义一个bean交个spring管理
    @Bean
    public Teacher teacher(){
        return new Teacher();
    }
}
