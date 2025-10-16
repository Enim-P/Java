package com.bing.p4;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量操作
 */
public class Test4 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>(){{
            this.add("A");
            this.add("B");
            this.add("C");
            this.add("D");
            this.add("E");
            this.add("F");
        }};
        List<String> list2 = new ArrayList<String>(){{
            this.add("A");
            this.add("C");
            this.add("E");
            this.add("G");
        }};
        System.out.println(list1);
        // addAll方法，用于将一个完整的集合添加到当前集合的末尾
        list1.addAll(list2);
        System.out.println(list1);
        List<String> list3 = new ArrayList<String>(){{
            this.add("A");
            this.add("B");
            this.add("C");
        }};
        // removeAll方法，用于异常指定集合中包含的所有元素
        list1.removeAll(list3);
        System.out.println(list1);
        List<String> list4 = new ArrayList<String>(){{
            this.add("E");
            this.add("F");
        }};
        // retainAll方法，用于只保留指定集合中包含的元素
        list1.retainAll(list4);
        System.out.println(list1);
    }
}
