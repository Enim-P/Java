package p4;

import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        int[] score = {33,45,22,17,8};
        // 手写算法，多数组排序
        // 1.冒泡排序算法
        // 外层循环控制比较轮数
        for(int i=0;i<score.length-1;i++){
            // 内层循环控制每轮比较次数
            // i在递增，j每轮能取到的值在递减
            for(int j=0;j<score.length-1-i;j++){
                // 每次用前面的数跟后面的数比较，如果前面的数大于后面的数，就互换位置
                if(score[j]>score[j+1]){
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
        }
        //Arrays的toString方法，用于将数组中的内容转为字符串数据
        System.out.println(Arrays.toString(score));
    }
}
