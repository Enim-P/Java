package com.bing.school.p9;

/**
 * 员工类
 */
public class Employee {
    // 工号
    private int no;
    // 姓名
    private String name;

    public Employee() {
    }

    public Employee(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 工作方法
    public void jop(){
        System.out.println("员工要工作...");
    }
}
