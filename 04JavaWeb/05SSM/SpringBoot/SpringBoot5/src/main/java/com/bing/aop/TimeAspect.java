package com.bing.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类，也叫AOP类
 */
@Component    // Spring管理的Bean
@Aspect       // AOP类
public class TimeAspect {

    // 该切面方法，用于给指定的业务方法做增强
    // @Around注解，用于定义环绕通知，相当于用它定义一个切点，就是在原始方法的什么位置进去切入
    // execution(* com.bing.service.StudentService.sayHi(..))是切点表达式，用于明确切点的位置
    // execution(* com.bing.service.*.*(..))：表示对应service下面的所有类的所有方法做增强

    // 通知类型包括：
    // @Around：环绕通知
    // @Before：前置通知
    // @After：后置通知，无论是否发生异常，都会执行
    // @AfterReturning：返回后通知，如果发生异常，不会执行
    // AfterThrowing：异常后通知，发生异常，才会执行

    // @Pointcut注解，用于将公共的切点表达式抽取出来，定义统一的切点
    @Pointcut("execution(* com.bing.service.StudentService.sayHi(..))")
    public void pt(){}


    // 直接在通知注解中定义切点表达式
    //@Before("execution(* com.bing.service.StudentService.sayHi(..))")
    @Before("pt()")   // 在通知注解中调用统一的切点方法，由该切点方法返回切点表达式
    public void beforeAspect(){
        System.out.println("插入前置功能...");
    }

    //@After("execution(* com.bing.service.StudentService.sayHi(..))")
    @After("pt()")
    public void afterAspect(){
        System.out.println("插入后置功能...");
    }

    //@AfterReturning("execution(* com.bing.service.StudentService.sayHi(..))")
    @AfterReturning("pt()")
    public void afterReturningAspect(){
        System.out.println("插入返回后功能...");
    }

    //@AfterThrowing("execution(* com.bing.service.StudentService.sayHi(..))")
    @AfterThrowing("pt()")
    public void afterThrowingAspect(){
        System.out.println("发生了异常...");
    }

    @Around("execution(* com.bing.service.StudentService.sayHello(..))")
    public Object aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        long time1 = System.currentTimeMillis();
        System.out.println("开始计算执行时间....");
        // 通过调用ProceedingJoinPoint对象的proceed方法来执行原始方法
        Object ret = joinPoint.proceed();
        System.out.println("执行时间计算完毕....");
        long time2 = System.currentTimeMillis();
        System.out.println("执行总耗时："+(time2-time1)+"ms");
        return ret;
    }
}
