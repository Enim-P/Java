package com.bing.p11;

public class Child extends Parent {
    // 这里的@Override就是一个注解，表示该方法是重写父类的方法
    // 该注解只是一个标记，可以删除。如果父类没有这个方法，添加该注解会报错
    @Override
    public void sayHi() {
        System.out.println("这里是子类的方法...");
    }

    // 注解就是一个标记，可以标记再类、方法、属性、参数、其他注解上。
    // 就是给程序的不同部位打上标记，是给反射用的
}
