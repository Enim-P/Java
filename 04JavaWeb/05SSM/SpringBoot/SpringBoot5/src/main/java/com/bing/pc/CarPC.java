package com.bing.pc;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义汽车切点的类
 */
public class CarPC {
    // 定义一个切点
    @Pointcut("execution(* com.bing.service.CarService.showCar(..))")
    public void pc(){}
}
