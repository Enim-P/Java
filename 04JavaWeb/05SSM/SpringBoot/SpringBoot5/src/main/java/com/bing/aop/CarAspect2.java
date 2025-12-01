package com.bing.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 切面类的执行顺序，默认是按照类名的字母排序
// 前置通知方法：字母靠前的先执行，后置通知方法：字母靠后的先执行。
@Component
//通过@Order注解，控制切面类的执行顺序，前置通知数字小的先执行，后置通知数字小的后执行
@Order(1)
@Aspect
public class CarAspect2 {

    //@Before("execution(* com.bing.service.CarService.showCar(..))")
    @Before("com.bing.pc.CarPC.pc()")
    public void addPrice(){
        System.out.println("价格：100W");
    }

    //@After("execution(* com.bing.service.CarService.showCar(..))")
    @After("com.bing.pc.CarPC.pc()")
    public void addColor(){
        System.out.println("类型：跑车");
    }
}
