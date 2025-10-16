package com.bing.school.p14;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 成员内部类，属于外部类的对象
        Student student = new Student();
        // 创建成员内部类对象的语法
        Student.Inner inner = student.new Inner();
        inner.sayHi();
        System.out.println("-----------");
        // 创建静态内部类对象的语法
        Student.Car car = new Student.Car();
        car.run();
        System.out.println("-----------");
        // 在定义学习方法时，在方法内部会创建一个内部类对象，执行相关业务
        student.study();
    }
}
