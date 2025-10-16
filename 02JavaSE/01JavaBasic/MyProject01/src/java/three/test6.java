package three;

import java.util.Scanner;

/**
 * 练习
 */
public class test6 {
    public static void main(String[] args) {
        /*
            输入5个学生的成绩，并计算出他们的平均分
        */
        Scanner input = new Scanner(System.in);
        int sum =0;
        for(int m = 1;m<=5;m++) {
            System.out.println("请输入第"+m+"位学生的成绩：");
            int score = input.nextInt();
            sum += score;
        }
        System.out.println("学生的平均分为："+(sum/5));
    }
}
