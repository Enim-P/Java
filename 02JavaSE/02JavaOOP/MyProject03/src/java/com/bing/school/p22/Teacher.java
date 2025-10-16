package com.bing.school.p22;

/**
 * 老师
 */
public class Teacher extends Person implements Exam {
    @Override
    public void eat() {
        System.out.println("老师要吃饭");
    }

    @Override
    public void sport() {
        System.out.println("老师要运动");
    }

    @Override
    public void study() {
        System.out.println("老师要学习");
    }

    @Override
    public void exam() {
        System.out.println("老师需要考试....");
    }
}
