package com.bing.p2;

/**
 * 学生类型
 */
// 在实现接口的时候，可以明确接口的泛型类型。如果不能明确接口的泛型类型，继续传递泛型
public class Student<T> implements ScoreInterface<T> {
    //学号
    private String id;
    //姓名
    private String name;
    //成绩
    private T score;

    public Student() {
    }

    public Student(String id, String name, T score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public T getScore() {
        return this.score;
    }

    @Override
    public void setSCore(T t) {
        this.score = t;
    }
}
