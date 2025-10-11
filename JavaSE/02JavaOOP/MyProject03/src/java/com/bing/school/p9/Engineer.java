package com.bing.school.p9;

/**
 * 软件开发工程师
 */
public class Engineer extends Employee {
    public Engineer() {
    }

    public Engineer(int no, String name) {
        super(no, name);
    }

    // 员工有工作的方法，但是该方法具体的某个子类时，工作的性质会发生变，所以要对该方法重写

    @Override
    public void jop() {
        System.out.println("软件开发工程，每天要写代码...");
    }


}
