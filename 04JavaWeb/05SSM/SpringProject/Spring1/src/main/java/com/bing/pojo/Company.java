package com.bing.pojo;

public class Company {
    private String name;
    private int age;

    public Company() {
    }

    public Company(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHi(){
        System.out.println("这里是"+name+"，我们已经成立"+age+"年");
    }
}
