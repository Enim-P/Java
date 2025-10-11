package com.bing.school.p11;

public class Test {
    public static void main(String[] args) {
        // 创建两个动物对象
        Animal a1 = new Cat();
        Animal a2 = new Dog();
        a1.eat();
        a2.eat();
        System.out.println("-------------");
        //抽象类不允许实例化
        //Animal a3 = new Animal();
        //a3.eat();
    }
}
