package p4;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 从控制台输入5个学生的成绩，将5个成绩保存到数组中
        int[] scores = new int[5];
        // 利用for循环，循环数组的下标
        for(int i=0;i<scores.length;i++){
            System.out.print("请输入第"+(i+1)+"位学生成绩：");
            scores[i] = input.nextInt();
        }
        // 计算所有学生的平均分，找出最高分和最低分
        int sum = 0;  //表示总分
        int max = scores[0];   //假设最高分是数组中的第一个元素
        int min = scores[0];   //假设最低分是数组中的第一个元素
        for(int i=0;i<scores.length;i++){
            sum += scores[i];
            //比较最高分
            if(scores[i]>max){
                max = scores[i];
            }
            //比较最低分
            if(scores[i]<min){
                min = scores[i];
            }
        }
        // 计算平均成绩
        int avg = sum / scores.length;
        System.out.println("学生的平均成绩："+avg);
        System.out.println("最高分："+max);
        System.out.println("最低分："+min);
    }
}
