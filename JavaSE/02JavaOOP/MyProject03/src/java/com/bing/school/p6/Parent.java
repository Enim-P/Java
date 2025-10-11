package com.bing.school.p6;

/**
 * 父类
 */
public class Parent {
    //私有的
    private int num1 = 100;
    //默认的
    int num2 = 200;
    //受保护的
    protected int num3 = 300;
    //公共的
    public int num4 = 400;

    public void fun1(){
        // 在当前类中，可以访问所有访问权限的成员
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
    }
}
