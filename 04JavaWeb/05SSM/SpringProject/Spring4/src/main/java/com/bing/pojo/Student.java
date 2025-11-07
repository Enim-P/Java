package com.bing.pojo;

import org.springframework.stereotype.Component;

@Component  //设置为spring的组件
public class Student {
    public int strLength(String str){
        System.out.println("参数内容为："+str);
        return str.length();
    }
}
