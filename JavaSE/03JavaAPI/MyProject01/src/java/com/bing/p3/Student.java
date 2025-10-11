package com.bing.p3;

public class Student {
    private Integer no;
    private String name;
    private String sex;

    public Student() {
    }

    public Student(Integer no, String name, String sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
