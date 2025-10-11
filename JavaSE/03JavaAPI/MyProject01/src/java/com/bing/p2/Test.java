package com.bing.p2;

public class Test {
    public static void main(String[] args) {
        // 创建学生对象的时候，确定了学生类的泛型类型是Integer
        // 那么学生类实现的ScoreInterface的泛型类型也是Integer
        Student<Integer> student = new Student<>("1001","张三",100);
        Integer ret1 = student.getScore();
        System.out.println(ret1);
        // 可以直接将学生对象赋值给ScoreInterface<Integer>接口类型
        ScoreInterface<Integer> scoreInterface1 = student;
        System.out.println("-----------------");
        Teacher teacher = new Teacher("1002","李四","优秀");
        String ret2 = teacher.getScore();
        System.out.println(ret2);
        // 虽然老师类型实现了ScoreInterface接口，但是接口的泛型类型不一样
        //ScoreInterface<Integer> scoreInterface2 = teacher;
    }
}
