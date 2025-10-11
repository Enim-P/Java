package com.bing.school.p4;

/**
 * 老师类
 */
public class Teacher {
    private int no;
    private String name;
    private String sex;

    //快速生成无参和带参构造
    public Teacher() {
    }
    public Teacher(int no, String name, String sex) {
        this.no = no;
        this.name = name;
        this.sex = sex;
    }

    //快速封装get和set方法
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Teacher{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
