package p4;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] score = {33,45,22,17,8};
        // 手写算法，多数组排序
        // 2.选择排序算法
        // 外层循环控制每轮比较的数
        for(int i=0;i<score.length-1;i++){
            // 内层循环控制每轮参与比较的数
            for(int j=i+1;j<score.length;j++){
                // 每轮比较的数据 和 参与比较的数 挨个比
                if(score[i]>score[j]){
                    int temp = score[i];
                    score[i] = score[j];
                    score[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(score));
    }
}
