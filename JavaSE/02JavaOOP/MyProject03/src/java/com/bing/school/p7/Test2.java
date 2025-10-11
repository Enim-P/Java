package com.bing.school.p7;

public class Test2 {
    public static void main(String[] args) {
        Parent p1 = new Parent(1001,"张三");
        Parent p2 = new Parent(1001,"张三");
        // 直接输出对象，调用的是对象的toString方法
        // toString方法，默认返回的是的地址，根据需要可以对该方法重写
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1==p2);
        System.out.println("----------------------");
        // 查看内存地址
        System.out.println(p1.hashCode());
        System.out.println("----------------------");
        // 对象的equals方法，默认是比较地址
        System.out.println(p1.equals(p2));
    }
}
