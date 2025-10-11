package com.bing.school.p14;

/**
 * 吃接口
 */
public interface Eat {
    // 接口方法
    void eat();

    default void eat2(){
        System.out.println("藏一点吃的....");
    }
}
