package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 添加@SpringBootApplication注解的类，是SpringBoot应用程序的起步类
@SpringBootApplication
public class SpringBoot1Application {

    // 必须包含一个main方法
    public static void main(String[] args) {
        // main方法中，只需要包含一行代码
        // SpringApplication.run -> 当前SpringBoot应用程序的起步类
        SpringApplication.run(SpringBoot1Application.class, args);
    }
}

// 这个项目是采用生成器创建的
