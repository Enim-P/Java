package com.bing.school.p14;

/**
 * 内部类：在某个东西内部的类
 */
public class Student {

    //情况1：成员内部类，在类的内部，又定义了一个类，这个类的对象通过外部类对象创建
    class Inner{
        public void sayHi(){
            System.out.println("你好！！！");
        }
    }

    //情况2：静态内部类，也是在类的内部定义，这个类的对象通过外部类访问来创建
    static class Car{
        public void run(){
            System.out.println("正在形式...");
        }
    }

    //情况3：局部内部类，在方法内部定义的类
    public void study(){
        // 这里是一个局部内部类
        class Teacher{
            public void sk(){
                System.out.println("正在上课...");
            }
        }
        // 具备内部类，只能在当前方法内部使用
        Teacher t = new Teacher();
        t.sk();
    }

}
