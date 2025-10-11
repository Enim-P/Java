package com.bing.school.p22;

/**
 * 员工
 */
public class Employee extends Person {
    @Override
    public void eat() {
        System.out.println("员工要吃饭");
    }

    @Override
    public void sport() {
        System.out.println("员工要运动");
    }

    @Override
    public void study() {
        System.out.println("员工要学习");
    }
}
