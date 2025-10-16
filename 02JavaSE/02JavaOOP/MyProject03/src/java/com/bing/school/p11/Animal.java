package com.bing.school.p11;

// 如果一个类太过于抽象，几乎不会被实例，此时就可以通过abstract关键字，将该类定义为抽象类
public abstract class Animal {
    // 抽象类，不允许被实例化，但是它必须有构造方法
    // 因为抽象类的构造方法不是给自己new的，是给子类实例化是new的
    // 所以抽象类只是不允许自己实例化，子类在实例化时依然会创建父类对象
    Animal(){
        System.out.println("动物被创建了...");
    }
    // 吃这个行为也很抽象，所有的子类几乎都会重写这个方法
    // 所以可以将该方法定义为抽象方法，依赖是使用abstract关键字
    // 注意：抽象方法不能定义方法体，非抽象子类必须要抽象父类的抽象方法
    public abstract void eat();

    public void run(){
        System.out.println("在运动...");
    }
}

// 总结：抽象类可以定义非抽象方法和抽象方法，有抽象方法的类必须要定位为抽象类。
