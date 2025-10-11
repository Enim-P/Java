package com.bing.p1;

// 注意：泛型不支持基本类型，int、double等等都不支持，只能是Integer、Double
// T是泛型占位符，在创建对象时指定具体的类型，默认情况下它是没有约束的，传什么都行
// 可以在定义泛型时，设置泛型的界限，其实就是加约束
public class Student2<T extends Number> {
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

    public Student2() {
    }

    public Student2(Integer no, String name, T score) {
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
