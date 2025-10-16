package com.bing.p4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 迭代器
 */
public class Test7 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<Integer>(){{
            this.add(42);
            this.add(38);
            this.add(55);
            this.add(26);
            this.add(12);
        }};
        // 遍历集合的方式很多：
        // 1. for：通过遍历集合的索引，再通过索引拿到对应的元素
        for(int i=0;i<list1.size();i++){
            System.out.print(list1.get(i)+" ");
        }
        System.out.println();
        // 2.foreach：直接遍历集合中所有的元素
        for(Integer num : list1){
            System.out.print(num+" ");
        }
        System.out.println();
        // 3.使用集合自己的forEach方法，遍历所有元素
        // forEach方法的参数是Consumer接口的实现
        list1.forEach(num->{
            System.out.print(num+" ");
        });
        System.out.println();
        // 4.通过Iterable迭代器的Iterator迭代方法实现
        // 返回当前集合的迭代器
        Iterator<Integer> iterator = list1.iterator();
        // hasNext方法，表示是否有下一个元素
        while (iterator.hasNext()){
            // next方法，用于返回下一个元素
            // 注意：如果没有下一个月元素，强行获取会发生异常
            Integer i = iterator.next();
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
