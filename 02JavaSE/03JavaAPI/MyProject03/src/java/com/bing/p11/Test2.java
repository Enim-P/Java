package com.bing.p11;

import java.lang.annotation.Annotation;

public class Test2 {
    public static void main(String[] args) {
        Class<Test> clazz = Test.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations){
            System.out.println(a);
            // 判断它是否使用了MyAnnotion2注解
            if(a.annotationType().getSimpleName().equals("MyAnnotion2")){
                // 获取在MyAnnotion2注解中赋值的属性
                MyAnnotion2 annotion2 = (MyAnnotion2)a;
                System.out.println(annotion2.abc());
            }
            // 通过instanceof关键字也可以判断
            if(a instanceof MyAnnotion2){
                // 获取在MyAnnotion2注解中赋值的属性
                MyAnnotion2 annotion2 = (MyAnnotion2)a;
                System.out.println(annotion2.abc());
            }
        }
    }
}
