package com.bing.p7;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 如何获取类型的Class对象
        // 1.通过类型的class关键字获取
        // 使用指定的类型.class，它可以明确的知道类型是什么，比如String.class，类型一定是String
        Class<String> c1 = String.class;

        // 2.通过Class类的forName方法获取，方法参数是指定类的全称
        // 这里的泛型类型为什么使用通配符?，那是因为forName方法的参数是一个字符串，它没有办法确定类型
        Class<?> c2 = Class.forName("java.lang.String");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1==c2);
        
        // 3.通过指定类型的对象，去获取该类型的Class对象
        Class<? extends String> c3 = new String("abc").getClass();
        System.out.println(c3);
        System.out.println(c1==c3);
        System.out.println("-------------------");
        Class<Integer> i1 = Integer.class;
        // 基本类型也有Class对象，
        Class<Integer> i2 = int.class;
        System.out.println(i1);
        System.out.println(i2);
        // 注意：Integer类型的Class对象 和 int类型的Class对象 不是同一个对象
        System.out.println(i1==i2);

        //总结一下：获取类型的Class对象的三种方式：
        //1.通过类的class关键字，2.通过Class类的forName方法，3.通过对象的getClass方法

    } 
}
