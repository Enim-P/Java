package com.bing.aop;

import com.bing.pojo.Student;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

//2.定义切面类
public class StudentAop {
    //在切面类里面定义切入动作

    //执行前增强的方法（增强的方法就是一个切面）
    /*public void before(){
        System.out.println("我是执行之前");
    }*/

    //通过JoinPoint类型的参数，可以拿到原始方法的相关信息
    public void before(JoinPoint point){
        System.out.println("我是执行之前");
        System.out.println(point.getTarget());   // 获取到执行方法的对象
        System.out.println(Arrays.toString(point.getArgs()));     // 获取到执行方法的参数
        System.out.println("---------------------");
    }

    //执行后增强的方法
    /*public void after(){
        System.out.println("我是执行之后");
    }*/

    public void after(JoinPoint point){
        System.out.println("---------------------");
        System.out.println(point.getTarget());   // 获取到执行方法的对象
        System.out.println(Arrays.toString(point.getArgs()));     // 获取到执行方法的参数
        System.out.println("我是执行之后");
    }
}
