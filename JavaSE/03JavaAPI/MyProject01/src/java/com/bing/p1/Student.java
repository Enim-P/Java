package com.bing.p1;

/**
 * 学生类
 */
// 当类中的成员的具体类型是在创建对象时才确定，此时可以给该类定义为泛型类
// 方式:<类型占位符,....>，类型占位符充当数据类型用
public class Student<T> {
    //学号
    Integer no;
    //姓名
    String name;
    //成绩
    T score;

    // set方法的参数类型是泛型T
    public void setScore(T score){
        this.score = score;
    }

    //get方法的返回值类型是泛型T
    public T getScore(){
        return this.score;
    }

    public Student() {
    }

    public Student(Integer no, String name, T score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
