package com.bing.p4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LinkedList
 */
public class Test5 {
    public static void main(String[] args) {
        // ArrayList用于的方法，LinkedList也具备，因为我也是List接口的实现类
        // ArrayList：数组列表，内部结构就是一个数组
        // LinkedList：链表，内部结构类似链条
        // ArrayList具备更快的遍历速度
        // LinkedList具备更快的编辑速度
        LinkedList<String> list1 = new LinkedList<String>(){{
            this.add("A");
            this.add("B");
            this.add("C");
            this.add("D");
        }};
        System.out.println(list1);
        list1.remove("C");
        System.out.println(list1);
        // LinkedList还提供了一些它自己特有的方法
        list1.addFirst("Hello");
        list1.addLast("World");
        System.out.println(list1);
        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);
        System.out.println("-------------------");
        // 同时LinkedList它还是一个队列
        LinkedList<String> list2 = new LinkedList<String>();
        // 队列就有入队和出队的行为
        list2.offer("A");  //入队
        list2.offer("B");
        list2.offer("C");
        System.out.println(list2);
        list2.poll(); //出队
        System.out.println(list2);
        // 注意：队列的进出关系是，先进先出
        System.out.println("-------------------");
        // LinkedList还提供了进栈和出栈的方法
        LinkedList<String> list3 = new LinkedList<String>();
        list3.push("A");  //进栈
        list3.push("B");
        list3.push("C");
        System.out.println(list3);
        list3.pop();  //出栈
        System.out.println(list3);
        // 注意：栈空间是先进后出

    }
}
