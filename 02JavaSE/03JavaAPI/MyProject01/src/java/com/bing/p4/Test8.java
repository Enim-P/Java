package com.bing.p4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 批量操作补充
 */
public class Test8 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<Integer>(){{
            this.add(42);
            this.add(38);
            this.add(38);
            this.add(55);
            this.add(26);
            this.add(26);
            this.add(12);
        }};
        System.out.println(list1);
        // 批量替换集合中的元素
        list1.replaceAll(num->{
            // 在方法中，可以根据条件返回，对数组的元素进行替换
            if(num==38){
                return 380;
            }else if(num==26){
                return  260;
            }else{
                return num;
            }
        });
        System.out.println(list1);
        // 将集合中所有的偶数加1
        list1.replaceAll(num->{
            if(num%2==0){
                return num+1;
            }else{
                return num;
            }
        });
        System.out.println(list1);
        System.out.println("----------------------");
        List<Student> students = new ArrayList<Student>(){{
            this.add(new Student(1001,"小明",12));
            this.add(new Student(1002,"小强",15));
            this.add(new Student(1003,"小芳",17));
            this.add(new Student(1004,"小红",19));
        }};
        // 如果学生的年龄小于18岁，统一改成18岁
        students.replaceAll(s -> {
            if(s.getAge()<18){
                s.setAge(18);
                return s;
            }else{
                return s;
            }
        });
        System.out.println(students);
    }
}
