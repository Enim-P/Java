package com.bing.school.p5;

/**
 * 狗类
 */
// 在java中，一个类可以继承另一个类，使用extends关键字
// 被继承的类称为：父类，继承的类称为：子类，此时Animal是Dog的父类，Dog是Animal的子类
// 子类继承父类后，将会拥有父类的所有非私有成员（本质上是全部继承了，只是私有的它无法访问）
public class Dog extends Animal {
    public void jiao(){
        System.out.println("狗狗在叫...");
    }
    public void run(){
        System.out.println("狗狗在跑...");
    }
}
