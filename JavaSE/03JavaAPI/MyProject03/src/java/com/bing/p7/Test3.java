package com.bing.p7;

import java.lang.reflect.Type;

public class Test3 {
    public static void main(String[] args) {
        Class<String[]> c1 = String[].class;
        // 获取类名称（类的全名称，包名+类的完整名称）
        System.out.println(c1.getName());
        // 获取类型名称(短名称)
        System.out.println(c1.getSimpleName());
        // 获取类型名称(长名称)
        System.out.println(c1.getTypeName());
        // 获取加载器，系统类的加载器被保护了，所以返回null
        System.out.println(c1.getClassLoader());
        System.out.println("-----------------");
        String str = "";
        // 判断一个对象的类型
        System.out.println(str instanceof String);
        System.out.println(str.getClass() == String.class);  //这样也能判断一个对象的类型
        Integer i = 10;
        // asSubclass方法，判断是否是子类
        System.out.println(i.getClass().asSubclass(Number.class));
        // getSuperclass方法，获取父类的Class对象
        // 返回的是Class对象
        System.out.println(i.getClass().getSuperclass());
        // 返回的是Type对象
        System.out.println(i.getClass().getGenericSuperclass());
        System.out.println("-----------------");
        // getInterfaces方法，返回所有的实现接口的Class对象
        for (Class<?> a : i.getClass().getInterfaces()){
            System.out.println(a.getName());
        }
        System.out.println("-----------------");
        // getGenericInterfaces方法，返回所有的实现接口的Type类型
        for(Type t : i.getClass().getGenericInterfaces()){
            System.out.println(t.getTypeName());
        }
    }
}
