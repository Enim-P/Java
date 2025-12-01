package com.bing.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(2)
@Aspect
public class CarAspect1 {

    //@Before("execution(* com.bing.service.CarService.showCar(..))")
    @Before("com.bing.pc.CarPC.pc()")
    public void addAddress(){
        System.out.println("产地：意大利");
    }

    //@After("execution(* com.bing.service.CarService.showCar(..))")
    @After("com.bing.pc.CarPC.pc()")
    public void addColor(){
        System.out.println("颜色：白色");
    }
}
