package three;

import java.util.Scanner;

/**
 * 小型ATM机系统
 */
public class test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = 10000; // 当前存款金额
        int no = 0; //菜单变量
        do{
            System.out.println("请选择操作（1.查看余额 2.存款 3.取款 0.退出系统 ");
            no = input.nextInt();
            if(no==1){
                System.out.println("您的存款余额为：" + money);
            }else if(no==2){
                System.out.println("请输入存款金额：");
                int ck = input.nextInt();
                System.out.println("存入成功，您当前账户余额为：" + (ck+money));
                money +=ck;
            }else if(no==3){
                System.out.println("请输入取款金额：");
                int qk = input.nextInt();
                if(qk > money){
                    System.out.println("对不起，余额不足！");
                }else{
                    System.out.println("取款成功，您当前账户剩余" + (money-qk));
                    money -=qk;
                }
            }else if(no==0){
                System.out.println("退出系统成功！");
            }else{
                System.out.println("输入错误...");
            }
        }while(no != 0);
    }
}
