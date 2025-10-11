package one;
import java.util.Scanner;
/**
 * 测试10
 * */
public class test10 {
    public static void main(String[] args) {
        //创建scanner对象
        Scanner input  = new Scanner(System.in);
        System.out.print("请输入金额：");
         int money = input.nextInt();
        System.out.println("您输入的金额是：" + money);

    }
}
