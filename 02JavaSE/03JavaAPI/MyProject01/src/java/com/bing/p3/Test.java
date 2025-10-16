package com.bing.p3;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 创建一个集合对象，集合的长度为10
        MyList<Integer> myList1 = new MyList<>(10);
        myList1.add(100);
        myList1.add(200);
        myList1.add(300);
        myList1.add(400);
        Integer ret1 = myList1.get(2);
        System.out.println(ret1);
        System.out.println("--------------");
        // 现在这个集合的类型是String，只能往该集合中添加String类型的数据
        MyList<String> myList2 = new MyList<>(10);
        myList2.add("你好");
        myList2.add("在干嘛");
        myList2.add("吃饭了");
        String ret2 = myList2.get(1);
        System.out.println(ret2);
        System.out.println("--------------");
        // 现在这个集合的类型是Student，只能往该集合中添加Student类型的对象
        MyList<Student> myList3 = new MyList<>();
        myList3.add(new Student(1001,"张三","男"));
        myList3.add(new Student(1002,"李四","女"));
        myList3.add(new Student(1003,"王五","男"));
        Student student = myList3.get(0);
        System.out.println(student);
        System.out.println("--------------");
        // 下面我们就引出Java里面的一个核心API，集合List

    }
}
