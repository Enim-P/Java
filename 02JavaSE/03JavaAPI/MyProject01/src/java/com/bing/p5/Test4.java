package com.bing.p5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Map集合
 */
public class Test4 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        // 注意：HashMap在存储数据时，内部也是通过哈希表的计算结果来进行存储的
        map.put(5,"A");
        map.put(1,"B");
        map.put(4,"C");
        map.put(2,"D");
        System.out.println(map);
        System.out.println("------------");
        // 使用LinkedHashMap存储数据，添加的顺序跟存储的顺序保持一致
        // LinkedHashMap是HashMap子类
        LinkedHashMap<Integer,String> map2 = new LinkedHashMap<>();
        map2.put(5,"A");
        map2.put(1,"B");
        map2.put(4,"C");
        map2.put(2,"D");
        System.out.println(map2);
        System.out.println("------------");
        // TreeMap会自动对存储的数据进行排序，并且可以通过构造方法实现Comparator来自定义排序规则
        TreeMap<Integer,String> map3 = new TreeMap<>((a,b)->b-a);
        map3.put(5,"A");
        map3.put(1,"B");
        map3.put(4,"C");
        map3.put(2,"D");
        System.out.println(map3);
    }
}

// 总结：重点需要掌握List集合和它的实现类ArrayList，Map接口和它的实现类HashMap
