package com.bing.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component    // 添加@Component注解的类，才能被spring扫描到并添加到容器中管理
@Scope("singleton")  //@Scope注解设置创建默认，singleton是单例默认，默认就是单例默认，可以省略
public class Car {
    private String name;
    private Integer price;

    public Car(){
        System.out.println("Car创建了...");
    }
}
