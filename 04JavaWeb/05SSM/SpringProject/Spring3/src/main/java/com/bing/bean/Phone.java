package com.bing.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component   // 设置为组件（让spring能够扫描到）
@Scope("prototype")    //prototype为原型模式，每次获取bean对象时，都会被创建
public class Phone {
    private String name;
    private Integer price;

    public Phone(){
        System.out.println("Phone创建了...");
    }
}
