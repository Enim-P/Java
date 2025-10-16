package com.bing.p2;

// 老师类在实现成绩接口的时候，直接实现了接口的泛型类型
public class Teacher implements ScoreInterface<String> {
    private String id;
    private String name;
    // 老师的成绩类型明确为String类型
    private String score;

    public Teacher() {
    }

    public Teacher(String id, String name, String score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String getScore() {
        return this.score;
    }

    @Override
    public void setSCore(String s) {
        this.score = s;
    }
}
