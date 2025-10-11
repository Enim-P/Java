package com.bing.p9;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Car> clazz = Car.class;
        Car car = clazz.newInstance();
        //getField方法，获取属性
        Field no = clazz.getField("no");
        Field name = clazz.getField("name");
        //getDeclaredField方法，获取私有属性
        Field price = clazz.getDeclaredField("price");
        price.setAccessible(true);  //修改权限
        // 给属性赋值
        no.set(car,"苏A1001");
        name.set(car,"宝马");
        price.set(car,10000);
        // 拿到方法
        Method show = clazz.getMethod("show");
        // 执行方法
        show.invoke(car);
        System.out.println("----------------------");
        // 获取可以访问的所有属性
        Field[] fields = clazz.getFields();
        System.out.println(fields.length);
        for (Field f : fields){
            System.out.println(f.getName());
            System.out.println(f.getType());
        }
    }
}
