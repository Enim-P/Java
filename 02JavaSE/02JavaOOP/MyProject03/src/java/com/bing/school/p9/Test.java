package com.bing.school.p9;

/**
 * 测试工程师
 */
public class Test extends Employee {
    public Test() {
    }

    public Test(int no, String name) {
        super(no, name);
    }

    @Override
    public void jop() {
        System.out.println("测试工程师，要对项目的的业务进行测试...");
    }
}
