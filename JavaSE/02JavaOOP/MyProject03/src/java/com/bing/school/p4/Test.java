package com.bing.school.p4;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        //通过调用set方法，给成员变量赋值
        student.setNo(1001);
        student.setName("哈哈哈哈哈哈哈哈哈");
        student.setAge(10000);
        student.setSex("人妖");
        student.setScore(1000);
        System.out.println("-------------------");
        //通过调用get方法，获取成员变量的值
        System.out.println(student.getNo());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getSex());
        System.out.println(student.getScore());
        student.sayHi();
        System.out.println("----------------------");
        Teacher teacher = new Teacher(1001,"李白","男");
        // 直接打印teacher对象，调用的是对象的toString方法
        // 对象的toString方法默认是返回该对象的地址，这里我们重写的toString方法，返回的是对象身上的属性信息
        System.out.println(teacher);
    }
}
