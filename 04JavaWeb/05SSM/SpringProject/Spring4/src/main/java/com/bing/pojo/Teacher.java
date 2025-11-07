package com.bing.pojo;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    public int strLength(String str){
        System.out.println("参数内容为："+str);
        return str.length();
    }
}
