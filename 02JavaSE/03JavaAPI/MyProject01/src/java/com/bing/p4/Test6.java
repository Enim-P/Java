package com.bing.p4;

import java.util.LinkedList;
import java.util.List;

/**
 * 对集合排序
 */
public class Test6 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<Integer>(){{
            this.add(42);
            this.add(38);
            this.add(55);
            this.add(26);
            this.add(12);
        }};
        // 对集合排序，可以自己上手排序算法实现
        // sort方法，需要插入一个Comparator接口的实现
        // 这里我们可以直接使用Lambda表达式实现
        list1.sort((o1,o2)->{
            return  o1-o2;
        });
        System.out.println(list1);
        list1.sort((o1,o2)->o2-o1);
        System.out.println(list1);
    }
}
