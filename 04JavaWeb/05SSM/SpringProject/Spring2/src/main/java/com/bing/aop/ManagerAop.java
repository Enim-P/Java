package com.bing.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//Manager切面类
public class ManagerAop implements MethodInterceptor {
    // 环绕增强
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("方法执行之前....");
        String arg = invocation.getArguments()[0]+" 你好世界";
        System.out.println("-----------------------");
        // 直接执行原始方法
        //Object value = invocation.proceed();
        // 执行原始方法时传递改造后的参数
        // 反射
        Object value = invocation.getMethod().invoke(invocation.getThis(),arg);
        System.out.println("-----------------------");
        System.out.println("方法执行之后....");
        return value;
    }
}
