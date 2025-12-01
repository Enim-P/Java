package com.bing.pojo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Scope定义Bean的作用域
// 单例模式在容器初始化的时候，就会创建创建完毕，之后不会在创建
@Lazy  // @Lazy可以延迟对象的初始化，在对象第一次被时候时，再初始化
@Scope("singleton")   // 单例模式（默认就是单例模式）
@Component   // 成为Bean
public class Student {
    public Student(){
        System.out.println("创建了学生对象.");
    }
}
