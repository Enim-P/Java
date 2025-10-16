package three;

import java.util.Random;
import java.util.Scanner;

/**
 * 练习
 */
public class test8 {
    public static void main(String[] args) {
        // 这里我们先随机生成一个0-100之间的数
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        int num = r.nextInt(100);
        System.out.println(num);
        /*
            给五次机会，猜一下随机生成的数是多少
            每次要提醒用户是猜大了还是猜小了，如果猜对了直接退出循环
        */
        for(int i = 4; i>=0;i--){
            System.out.println("请输入您要猜的数字：");
            int reserve = input.nextInt();
            if(reserve > num){
                System.out.println("猜大了!还有"+i+"次机会");
            }else if(reserve < num){
                System.out.println("猜小了！还有"+i+"次机会");
            }else if(reserve == num){
                System.out.println("恭喜你猜对了");
                break;
            }
            if(i==0){
                System.out.println("您要猜的数其实是："+num);
            }
        }
    }
}
