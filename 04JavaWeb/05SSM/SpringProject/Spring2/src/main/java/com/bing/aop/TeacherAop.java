package com.bing.aop;

import org.aspectj.lang.ProceedingJoinPoint;

// Teacher切面类
public class TeacherAop {

    // 切面方法（通常叫做：通知方法）
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法执行之前...");
        System.out.println("原始方法的参数是："+joinPoint.getArgs()[0]);
        //拿到原始方法的参数进行更改
        String arg = joinPoint.getArgs()[0]+" 你好世界";
        System.out.println("--------------------------");
        //调用proceed方法，执行原始方法
        //Object value = joinPoint.proceed();
        //调用原始方法可以重新传递方法参数
        Object value = joinPoint.proceed(new Object[]{arg});
        System.out.println("--------------------------");
        System.out.println("方法执行之后...");
        return value;
    }
}
