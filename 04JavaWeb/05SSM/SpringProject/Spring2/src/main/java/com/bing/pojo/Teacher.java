package com.bing.pojo;

public class Teacher {

    // 该方法需要环绕增强
    public int strLength(String str){
        System.out.println("参数内容为："+str);
        return str.length();
    }
}
