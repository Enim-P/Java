package com.bing.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

// Employee切面类，直接实现指定的切面方法
public class EmployeeAop implements MethodBeforeAdvice, AfterReturningAdvice {

    // 方法之前切面方法
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我是方法执行之前...");
    }

    // 方法之前切面方法
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我是方法执行之后...");
    }
}
