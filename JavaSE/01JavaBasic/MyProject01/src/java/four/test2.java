package four;
import java.util.Scanner;
/**
 * 二重循环
 */
public class test2 {
    public static void main(String[] args) {
        /*
            有三个班级，每个班级有四名学生
            循环输入每个班级每个学生的成绩，并计算出每个班级的平均分
        */
        // 外层for,表示有三个班级
        Scanner input = new Scanner(System.in);
        for(int i = 1; i<=3; i++){
            System.out.println("请输入第"+i+"个班级的成绩");
            System.out.println("----------------------");
            int sum = 0; //定义每一个班级的总分
            // 内层for,表示每个班级有四名学生
            for(int j=1; j<=4;j++){
                System.out.print("请输入第"+j+"位学生的成绩");
                sum += input.nextInt();
                }
                int avg = sum/4; // 计算每一个班级的平均分
                System.out.println("第"+i+"位班级的平均分为："+(sum/4));
                System.out.println("----------------------");
            }

        }
        // 总结：外层循环的循环变量变化一次，内层循环的循环变量变化一遍
    }

