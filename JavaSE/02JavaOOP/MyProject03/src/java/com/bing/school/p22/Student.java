package com.bing.school.p22;

/**
 * 学生
 */
public class Student extends Person implements Exam {
    @Override
    public void eat() {
        System.out.println("学生要吃饭");
    }

    @Override
    public void sport() {
        System.out.println("学生要运动");
    }

    @Override
    public void study() {
        System.out.println("学生要学习");
    }

    @Override
    public void exam() {
        System.out.println("学生需要考试....");
    }
}
