package com.bing.school.p9;

/**
 * 项目经理
 */
public class Manager extends Employee {
    public Manager() {
    }

    public Manager(int no, String name) {
        super(no, name);
    }

    @Override
    public void jop() {
        System.out.println("项目经理，要对整个项目的开发进度进行把控...");
    }

    // 项目经理特有的方法
    public void social(){
        System.out.println("项目经理，有时还要出去应酬...");
    }
}
