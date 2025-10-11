package com.bing.school.p6.one;

import com.bing.school.p6.Parent;

public class Test {
    public static void main(String[] args) {
        Parent parent = new Parent();
        // 不同包下，通过对象名，只能访问公共权限的成员
        System.out.println(parent.num4);
    }
}
