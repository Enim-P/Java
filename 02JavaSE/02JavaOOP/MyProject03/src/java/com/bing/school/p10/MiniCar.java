package com.bing.school.p10;

// 无法继承最终类
public class MiniCar /* extends Car */ {
    // 成员变量（属性），定义为final后，必须要赋初始值
    // 可以直接赋值，也可以通过构造函数赋值
    // 一旦赋值完以后，基本类型的值不能再发生改变，引用类型的地址不能发生改变
    private final String name;
    private final int price;

    public MiniCar(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
