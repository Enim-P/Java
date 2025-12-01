package com.bing.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")  //多实例模式
@Component
public class Teacher {
    public Teacher(){
        System.out.println("创建了老师对象.");
    }
}
