package p4;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        // 创建数组并初始化数据，不需要指定数组的长度，数组的长度由初始化的数据确定
        int[] nums = new int[]{11,22,33,44,55};
        System.out.println(nums.length);
        // 创建数组并初始化数据的简写
        int[] nums2 = {11,22,33,44,55};
        System.out.println(nums2.length);
        System.out.println("--------------------------");
        int[] score = {33,45,22,17,8};
        // Arrays类的sort静态方法，用于对指定的数组排序
        Arrays.sort(score);
        // for循环是接住数组的下标输出数组中的数据
        for (int i = 0; i < score.length; i++) {
            // 这里的循环变量i，每次代表一个数组的下标
            System.out.println(score[i]);
        }
        System.out.println("---------");
        // foreach循环，只能用于遍历数组或集合
        // 它是利用一个循环变量，将数组中的所有元素遍历出来
        for(int i : score){
            // 这里的循环变量i，每次代表一个数组的元素
            System.out.println(i);
        }
        // 如果我们要遍历整个数组，推荐使用foreach循环，如果我们只是遍历数组中的指定区间的内容，只能用for
    }
}
