package com.bing.school.p16;

public class Test {
    public static void main(String[] args) {
        // 创建学生对象
        Student s1 = new Student();
        // 创建了一个飞机对象
        Plane plane = new Plane();
        // 调用学生的飞行方法
        s1.myFlay(plane);  //将飞机对象作为参数传给学生对象的飞行方法
        System.out.println("------------------");
        Student s2 = new Student();
        Rocket rocket = new Rocket();
        s2.myFlay(rocket);
        System.out.println("------------------");
        Student s3 = new Student();
        s3.myFlay(new Flay() {
            @Override
            public void flay(int height) {
                System.out.println("无人机在"+height+"米的高空飞行...");
            }
        });
        System.out.println("------------------");
        Student s4 = new Student();
        s4.myFlay(height -> System.out.println("滑翔伞在"+height+"米的高空飞行..."));
    }
}
