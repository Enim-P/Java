package com.bing.school.p5;

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        a.sleep();
        System.out.println("----------------");
        Dog d = new Dog();
        // 狗也是动物，它继承了动物的所有行为
        d.eat();
        d.sleep();
        // 这是狗自己的行为
        d.jiao();
        d.run();
        System.out.println("----------------");
        // Dog没有定义toString方法，它的父类Animal也没有定义，那这个toString方法从哪来？
        System.out.println(d.toString());
        //在java中有一个类叫：Object，它是超级父类，是所有类的父类，jdk成就是从这个类开始演变的
        //在java中，所以的类都直接或间接继承自Object

    }
}
