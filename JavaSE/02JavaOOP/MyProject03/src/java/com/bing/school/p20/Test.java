package com.bing.school.p20;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("张无忌");
        student.setAge(25);
        // 学生状态包括：学习、睡觉、吃饭、运动
        // 注意：学生的状态是枚举类型，枚举类型赋值，只能使用枚举.枚举项
        student.setStatus(Status.Eat);
        System.out.println(student);
        // 获取的依然是枚举选项
        System.out.println(student.getStatus());
        // 通过枚举选项的getName方法，获取当前选项对应的名称
        System.out.println(student.getStatus().getName());
    }
}
