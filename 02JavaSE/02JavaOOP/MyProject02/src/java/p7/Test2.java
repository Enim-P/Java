package p7;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 有三个班级，每个班级有4名学生，
        // 存储每个班级的所有学生的成绩，并计算出每个班级的平均分
        // 定义一个二维数组，存储所有学生的成绩
        int[][] scores = new int[3][4];
        for(int i=0;i<scores.length;i++){
            System.out.println("请输入第"+(i+1)+"个班级的学生成绩：");
            int sum = 0;  //定义总分
            for(int j=0;j<scores[i].length;j++){
                System.out.print("请输入第"+(j+1)+"位学生的成绩：");
                scores[i][j] = input.nextInt();
                sum += scores[i][j];  //累加每个班级的总分
            }
            int avg = sum / scores[i].length;
            System.out.println("第"+(i+1)+"个班级的平均分："+avg);
        }
    }
}
