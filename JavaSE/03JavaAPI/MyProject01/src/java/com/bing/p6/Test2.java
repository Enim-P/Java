package com.bing.p6;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        // 使用数组工具类快速将一个数组转为List
        // asList方法的采用的是可扩展参数，可以直接传数组，也可以直接传值
        // 此时返回的ArrayList实例是Arrays的一个内部类型，只提供了遍历元素的能力，没有提供添加元素的方法
        List<Student> students = Arrays.asList(
                new Student("张三",55),
                new Student("张三",44),
                new Student("张三",22),
                new Student("李四",99),
                new Student("李四",87),
                new Student("李四",79),
                new Student("王五",62),
                new Student("王五",38),
                new Student("王五",46)
        );
        // 可以通过set方法，更改指定位置的元素
        students.set(2,new Student("张三",33));
        System.out.println(students.size());
        Map<String,Integer> scoreMap = new HashMap<>();
        students.forEach(student -> {
            // merge方法，用于对相同key值的value做统计
            // 参数1：key
            // 参数2：value
            // 参数3：统计规则（规则方法可以自己实现，也可以用方法引用调用别人实现好的）
            scoreMap.merge(student.getName(),student.getScore(),Integer::sum);
        });
        System.out.println(scoreMap.size());
        scoreMap.forEach((k,v)->{
            System.out.println("姓名："+k+" 总分："+v);
        });
    }

    // 学生类
    static class Student{
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
