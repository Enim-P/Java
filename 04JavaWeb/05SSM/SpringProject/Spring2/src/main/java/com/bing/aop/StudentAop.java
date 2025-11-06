package com.bing.aop;

//2.定义切面类
public class StudentAop {
    //在切面类里面定义切入动作

    //执行前增强的方法（增强的方法就是一个切面）
    public void before(){
        System.out.println("我是执行之前");
    }

    //执行后增强的方法
    public void after(){
        System.out.println("我是执行之后");
    }
}
