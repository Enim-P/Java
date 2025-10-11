package com.bing.school.p8;

/**
 * 鳄鱼
 */
// 注意：java语言是不支持多继承的，只能继承一个父类（这叫做继承的单根性）
// 但是继承具有传递性，子类继承父类，父类还可以继续继承它的父类
public class Crocodile extends Reptile {
    public void ambush(){
        System.out.println("在伏击捕猎...");
    }
}
