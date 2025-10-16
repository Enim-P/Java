package four;

import java.util.Scanner;

/**
 * 在内层循环中使用跳出语句
 */
public class test5 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);

        /*
              有五家店，每家店最多可以买三件衣服
              进入一家店后，首先提示是否离开，输入Y表示离开，输入N表示买了一件衣服
              最后打印一共买了多少件衣服
         */
        int sum = 0; //
        for(int i = 1; i<=5;i++){
            System.out.println("进入了第"+i+"家店.....");
            for(int j =1; j<=3;j++){
                System.out.println("是否离开（Y/N）：");
                String s = input.next();
                if(s.equals("Y")){
                    break;
                }
                System.out.println("购买了一件衣服");
                sum++;
            }
        }
        System.out.println("您一共买了"+sum+"件衣服");
    }
}
