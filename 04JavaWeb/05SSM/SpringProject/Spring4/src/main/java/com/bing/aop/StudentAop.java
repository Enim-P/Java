package com.bing.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component  //交个Spring管理
@Aspect     //表示它是一个切面类
public class StudentAop {

    //通知方法（方法之前增强）
    @Before("execution(* com.bing.pojo.Student.strLength(..))")  //切点
    /*public void before(){
        System.out.println("我是方法执行之前...");
    }*/
    public void before(JoinPoint joinPoint){
        // 通过JoinPoint参数，可以拿到原始方法的相关信息
        System.out.println("我是方法执行之前...");
        Object arg = joinPoint.getArgs()[0];
        System.out.println("原始方法的参数是："+arg);
        System.out.println("------------------------");
    }
    //通知方法+切点 => 切面


    @AfterReturning("execution(* com.bing.pojo.Student.strLength(..))")
    public void after(){
        System.out.println("------------------------");
        System.out.println("我是方法执行之后...");
    }
}
