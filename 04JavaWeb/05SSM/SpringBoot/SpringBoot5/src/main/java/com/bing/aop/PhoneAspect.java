package com.bing.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PhoneAspect {

    // 切入点表达式：主用用来决定哪些方法需要加入通知
    // 形式有两种：
    // 1.execution：根据方法签名来匹配
    // 2.@annotation：根据注解匹配

    @After("execution(* com.bing.service.PhoneService.showPhone(..))")
    public void addPrice1(){
        System.out.println("价格：暂未公布");
    }

    @After("execution(* com.bing.service.PCService.showPC(..))")
    public void addPrice2(){
        System.out.println("价格：暂未公布");
    }

    // 对应所有添加了MyAnnotation注解的方法做增强
    @Before("@annotation(com.bing.annotation.MyAnnotation)")
    public void addAddress(){
        System.out.println("产地：未知");
    }
}
