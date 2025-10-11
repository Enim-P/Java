package com.bing.p10;

/**
 * 学生类
 */
public class Student {
    @Key   //就是标记那个字段对应数据库中表的主键
    public String no;
    // 注解就是在程序的不同部位打上对应的标记
    @Column("studentName")
    public String name;   //比如这里的属性名和数据表中的列名不一样，所以需要在这里打上标记，方便ORM框架反射使用
    public String sex;
    public int age;

    public Student() {
    }

    public Student(String no, String name, String sex, int age) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
