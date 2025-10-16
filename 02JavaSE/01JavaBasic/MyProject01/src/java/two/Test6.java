package two;

import java.util.Scanner;

/**
 * 练习
 * */
public class Test6 {
    public static void main(String[] args) {
        /*
            输入一个三位数，判断该数是不是水仙花数
            什么是水仙花数
            百位的三次方 + 十位三次方 + 个位三次方 == 这个数
         */
        System.out.print("请输入一个三位数：");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int bw = (number / 100);
        int sw = (number % 100 / 10);
        int gw = (number % 10);
        if ((int)Math.pow(bw,3) + (int)Math.pow(sw,3) + (int)Math.pow(gw,3)== number)
            System.out.println("这个数是水仙花数");
        else
            System.out.println("这个数不是水仙花数");
    }
}
