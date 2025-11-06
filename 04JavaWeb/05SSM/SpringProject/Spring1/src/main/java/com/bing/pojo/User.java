package com.bing.pojo;

//什么事JavaBean？
//JavaBean就是一个规范的Java类，字段使用private访问修饰符修饰，采用get和set方法对字段进行封装
//Spring-IoC容器可以帮我们管理程序中的JavaBean
//Spring-IoC容器可以帮助我们对项目进行解耦，就是将创建对象的过程交给容器帮我们完成
//IOC是Inversion of Control的缩写，翻译为：“控制反转”，实例化对象的控制权由之前的程序员转为现在的Spring框架

public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
