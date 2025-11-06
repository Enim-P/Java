package com.bing.pojo;

//1.需要切入的类，类的哪个方法需要被切入
public class Student {

    // 当前方法就是需要被切入的方法，也就是需要增强的方法
    public int strLength(String str){
        System.out.println("参数内容为："+str);
        return str.length();
    }
}
