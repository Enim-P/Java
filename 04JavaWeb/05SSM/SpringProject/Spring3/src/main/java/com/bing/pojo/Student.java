package com.bing.pojo;

import com.bing.bean.Car;

public class Student {
    private String name;
    private int age;
    private Car car;

    public Student(){
        System.out.println("Student创建了...");
    }

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
