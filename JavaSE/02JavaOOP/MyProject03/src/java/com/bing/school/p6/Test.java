package com.bing.school.p6;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建父类
        Parent p = new Parent();
        // 在同包下，通过对象名可以访问：默认、受保护、公共权限的成员
        System.out.println(p.num2);
        System.out.println(p.num2);
        System.out.println(p.num3);
    }
}
