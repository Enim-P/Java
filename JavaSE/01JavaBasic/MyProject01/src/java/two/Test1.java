package two;
import java.util.Scanner;
/**
 * 练习
 * */
public class Test1 {
    public static void main(String[] args) {
        //需求从控制台输入一个年份，判断该年份是不是闰年，是闰年输出true，不是输出false
        //计算闰年的公式:年份能够被4整除并且不能被100整除 或者 年份能被400整除
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = input.nextInt();
        //boolean isLeepYear = year%4 == 0 && year%100 != 0 || year%400 == 0;
        System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}
