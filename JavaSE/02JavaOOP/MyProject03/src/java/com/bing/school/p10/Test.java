package com.bing.school.p10;

public class Test {
    public static void main(String[] args) {
        int num = 100;
        // 变量的值，是可以随时更改的
        num = 200;
        System.out.println(num);
        System.out.println("-----------------");
        // 在定义变量时，通过final关键字将变量设置为常量
        final int num2 = 100;
        // 常量是不能更改值的
        //num2 = 200;
        System.out.println(num2);
    }
}
