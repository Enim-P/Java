package com.bing.pojo;

public class School {
    private String name;
    private int age;

    public School(){
        System.out.println("School的构造函数...");
    }

    private void init(){
        System.out.println("School的初始化方法！");
    }
    private void destroy(){
        System.out.println("School的销毁方法！");
    }

}
