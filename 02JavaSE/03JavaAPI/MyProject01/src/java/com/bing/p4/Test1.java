package com.bing.p4;

import java.util.*;

/**
 * 引出集合的概念
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        System.out.println(nums.length);
        nums[0] = 100;
        nums[4] = 100;
        System.out.println(Arrays.toString(nums));
        System.out.println("-------------");
        // 使用数组存储数据它有两个必须要解决的问题：1.长度在创建的时候必须确定，2.索引必须要自己维护
        // 使用集合完美的解决了数组的所有问题
        // 创建一个集合，不用给长度，用多少自定开辟多长的空间
        ArrayList list = new ArrayList();
        // 通过size方法返回集合的长度
        System.out.println(list.size());
        // 通过add方法向集合中添加元素
        list.add(100);
        list.add(200);
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("-------------");
        // 集合有两大类型：Collection(集合) \ Map(映射：键值对)
        // Collection又分为三类：Set(集合) \ List(列表) \ Queue(队列)
        // Set又分为：HashSet(哈希集合) \ TreeSet(数集合)
        // HashSet和TreeSet是Set接口的实现类
        // List又分为：ArrayList(数组列表) \ LinkedList(链表)
        // ArrayList和LinkedList是List接口的实现类，LinkedList还实现了Queue接口（所以它也是一个队列）
        // Map又分为：HashMap(哈希映射) \ TreeMap(数形映射)
        // HashMap和TreeMap是Map接口的实现类
        // 重点需要掌握：1. Map接口和它的实现类HashMap 2. List接口和它的实现类ArrayList
    }
}
