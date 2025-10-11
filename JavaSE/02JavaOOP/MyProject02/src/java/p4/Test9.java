package p4;

import java.util.Arrays;
import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = {33,55,2,77,15,48};
        System.out.println(Arrays.toString(nums));
        System.out.print("请输入插入的数据：");
        int num = input.nextInt();
        System.out.print("请输入插入的位置：");
        int index = input.nextInt();
        // 需要重新创建一个新的数组，长度是之前的数组的长度+1
        // 将之前的数组和插入的数据，重新放到新的数组中，输出新的数组数据
    }
}
