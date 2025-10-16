package com.bing.school.p6;

/**
 * 同包子类
 */
public class Child extends Parent {
    public void show(){
        // 同包下的子类，可以访问父类：默认、受保护、公共权限的成员
        System.out.println(this.num2);
        System.out.println(this.num2);
        System.out.println(this.num3);
    }
}
