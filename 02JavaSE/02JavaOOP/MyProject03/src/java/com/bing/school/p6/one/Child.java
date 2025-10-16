package com.bing.school.p6.one;

import com.bing.school.p6.Parent;

/**
 * 不同包下的子类
 */
public class Child extends Parent {
    public void show(){
        // 不同包下的子类，只能访问父类的：受保护、公共权限的成员
        System.out.println(this.num3);
        System.out.println(this.num4);
        // 总结：父类受保护的成员，就是专门给子类使用的，无论子类在哪里
    }
}
