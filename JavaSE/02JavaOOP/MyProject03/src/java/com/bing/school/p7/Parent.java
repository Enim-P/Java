package com.bing.school.p7;

import java.util.Objects;

/**
 * 父类
 */
public class Parent {
    private int no;
    private String name;

    public Parent(){

    }

    public Parent(int no, String name) {
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

    // 父类自己的方法
    public void sayHi(){
        System.out.println("大家好！欢迎光临！");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return no == parent.no && Objects.equals(name, parent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }
}
