package com.bing.p5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 练习
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = {11,22,33,44,55,11,22,22,33,11,55,66,77,33,44,55,99,88,55,88,99,33};
        // 对数组去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        System.out.println(set);
        // 将集合重新转为数组类型存储
        Object[] objects = set.toArray();
        System.out.println(Arrays.toString(objects));
    }
}
