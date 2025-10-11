package com.bing.p5;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Set集合
 */
public class Test1 {
    public static void main(String[] args) {
        //Set集合的特点：1.不允许出现重复元素 2.不支持通过索引访问
        //HashSet是Set接口的实现类
        HashSet<Integer> set = new HashSet<>();
        // 添加元素时，它不是按照添加的顺序存储元素，而是按照元素的哈希表的计算值进行存储的
        set.add(33);
        set.add(55);
        set.add(22);
        set.add(11);
        // 不能添加重复的数据
        set.add(55);
        System.out.println(set);
        System.out.println("-----------------");
        //LinkedHashSet是HashSet的子类，它可以按照元素的添加顺序存储
        LinkedHashSet set2 = new LinkedHashSet<>();
        set2.add(33);
        set2.add(55);
        set2.add(22);
        set2.add(11);
        System.out.println(set2);
        System.out.println("-----------------");
        //TreeSet也是Set接口的实现类，它采用的是红黑树结构存储数据
        TreeSet<Integer> set3 = new TreeSet<>();
        //TreeSet会对添加的元素进行排序
        set3.add(33);
        set3.add(55);
        set3.add(22);
        set3.add(11);
        System.out.println(set3);
        System.out.println("-----------------");
        //TreeSet的默认排序规则是升序，如果要降序排列，需要在构造方法中传入Comparator接口的实现，自定义排序规则
        TreeSet<Integer> set4 = new TreeSet<>((a,b)->b-a);
        set4.add(33);
        set4.add(55);
        set4.add(22);
        set4.add(11);
        System.out.println(set4);
    }
}
