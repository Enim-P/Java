package com.bing.p6;

import java.io.Serializable;

/**
 * 学生类
 */
// 实现Serializable接口，使该类具备可序列化
public class Student implements Serializable {
    private String no;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
