package com.bing.school.p16;

/**
 * 学生类
 */
public class Student {

    // 飞行方法
    public void myFlay(Flay flay){
        System.out.println("我是一名学生，我现在正在飞...");
        flay.flay(100);
    }

    // 实现多态的第一种方式：将父类类型或接口类型作为方法参数
    // 在调用方法时，传递该接口的具体实现类来实现多态
}
