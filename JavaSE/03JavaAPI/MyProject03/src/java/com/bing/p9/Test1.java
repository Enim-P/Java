package com.bing.p9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 使用放射的方式调用类的方法
        // 得到指定类型的Class对象（也就是反射对象）
        Class<?> clazz = Class.forName("com.bing.p9.Student");
        // 通过Class对象创建出对应类型的对象
        Object o = clazz.newInstance();
        // 通过Class对象拿到指定方法对象
        // getMethod方法用于反射出方法对象，参数1是方法名，从参数2开始是方法的形参列表
        Method test = clazz.getMethod("test", String.class);
        // 方法对象通过invoke执行方法
        // 方法本身是无法自己执行的，方法需要对象来执行它，
        // invoke方法的第1个参数是执行该方法的对象，第2个参数开始是方法的实参
        test.invoke(o,"哈哈");
        System.out.println("----------------------");
        // getDeclaredMethod可以获取到私有方法
        Method test2 = clazz.getDeclaredMethod("test2", String.class);
        test2.setAccessible(true);  //修改访问权限
        System.out.println(test2.getName());   //查看方法名
        System.out.println(test2.getReturnType());  //查看返回值类型
        double ret = (double)test2.invoke(o, "呵呵");
        System.out.println(ret);
    }
}
