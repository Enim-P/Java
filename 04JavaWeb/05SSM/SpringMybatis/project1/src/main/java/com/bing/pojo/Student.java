package com.bing.pojo;

import org.springframework.stereotype.Component;

@Component    // 只有添加了该注解的类才能被spring扫描到
public class Student {
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
