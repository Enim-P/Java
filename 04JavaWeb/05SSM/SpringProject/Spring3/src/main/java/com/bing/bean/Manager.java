package com.bing.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Manager {
    public Manager(){
        System.out.println("Manager被创建了...");
    }

    @PostConstruct   // 等价于之前在xml中配置的init-method
    public void init(){
        System.out.println("Manager的初始化方法...");
    }

    @PreDestroy  // 等价于之前在xml中配置的destroy-method
    public void destroy(){
        System.out.println("Manager的销毁方法...");
    }
}
