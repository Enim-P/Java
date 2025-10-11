package com.bing.school.p1;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建学生对象（使用同包中的类，不需要导入）
        Student student = new Student();
        // 学生的学号是私有的，只能在类的内部使用，外部无法使用
        //student.no = 1000;
        // 学生的姓名采用的是默认访问权限，可以在同包的不同类中访问
        student.name = "张三";
    }
}
