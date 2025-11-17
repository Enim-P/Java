package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   // 设置为起步类
public class SpringBoot2Application {
    public static void main(String[] args) {
        //run方法，需要传两个参数：1.起步类的class文件，2.main方法的args参数
        SpringApplication.run(SpringBoot2Application.class,args);
    }
}


// 这个项目是手动搭建的