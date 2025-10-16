package com.bing.p6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test8 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>(){{
            this.add(55);
            this.add(27);
            this.add(12);
            this.add(33);
            this.add(68);
        }};
        // reduce方法用于统计数据，规则自定义
        // reduce方法的返回值Optional，Optional是jkd8新增的用于处理null值的类
        // Optional的get()方法，用于返回Optional包装的值
        Integer ret1 = list.stream().reduce((a, b) -> {
            // a：是上一次计算的结果
            // b：是当前要计算的元素
            System.out.println(a+" "+b);
            return a + b;
        }).get();
        System.out.println(ret1);
        Integer ret2 = list.stream().reduce((a, b) -> a * b).get();
        System.out.println(ret2);
        System.out.println("-------------------");
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
        // 计算李四的总分
        int lsSum = students.stream()  //将学生集合转为Stream流
                .filter(s -> s.getName().equals("李四"))  //过滤出李四的数据
                .mapToInt(s -> s.getScore())  //将学生的成绩单独拉出返回一个IntStream流
                .reduce((a, b) -> a + b)  //统计求和
                .getAsInt();  //获取结果
        System.out.println(lsSum);
        System.out.println("-------------------");
        List<Student> students2 = Arrays.asList(
                new Student("小明",55),
                new Student("小王",44),
                new Student("小张",22),
                new Student("小李",99),
                new Student("小红",87),
                new Student("小强",79),
                new Student("小芳",62),
                new Student("小明",38),
                new Student("小爱",46)
        );
        // 返回集合中成绩小于60分的学生，并且降序排列
        List<Student> list2 = students2.stream()
                .filter(s -> s.getScore() < 60)
                .sorted((a, b) -> b.getScore() - a.getScore())
                .collect(Collectors.toList());
        list2.forEach(s->{
            System.out.println(s);
        });
        System.out.println("-------------------");
        // 获取第一个元素
        Student student = students2.stream()
                .filter(s->s.getName().equals("小明")).findFirst().get();
        System.out.println(student);
        System.out.println("-------------------");
        // 将成绩小于60分改成60分
        List<Student> stu2 = students2.stream().map(s -> {
            if (s.getScore() < 60) {
                s.setScore(60);
                return s;
            } else {
                return s;
            }
        }).collect(Collectors.toList());
        // 遍历结果
        stu2.forEach(System.out::println);
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
