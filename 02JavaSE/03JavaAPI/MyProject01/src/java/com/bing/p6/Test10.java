package com.bing.p6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {
        // Arrays：数组工具类
        // Collections：集合工具类
        int[] array = {33,22,11,55,44};
        // asList方法，用于将数组转为集合
        List<int[]> ints = Arrays.asList(array);
        // sort对数组排序
        Arrays.sort(array);
        // toString将数组内容转为字符串
        System.out.println(Arrays.toString(array));
        // fill填充数组
        Arrays.fill(array,100);
        System.out.println(Arrays.toString(array));
        String[] array2 = {"A","B","C","D","E","B","C"};
        // stream方法，将指定的数组转为Stream流
        Object[] objects = Arrays.stream(array2).filter(s -> s.equals("B")).toArray();
        System.out.println(Arrays.toString(objects));
        System.out.println("---------------------");
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(300);
        list.add(200);
        System.out.println(list);
        // 翻转集合
        Collections.reverse(list);
        System.out.println(list);
        // 对集合排序
        Collections.sort(list);
        System.out.println(list);
        // 获取集合中的最大值和最小值
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println(max);
        System.out.println(min);
    }
}
