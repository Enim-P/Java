package two;

import java.util.Scanner;

/**
 * 练习
 */
public class Test8 {
    public static void main(String[] args) {
        /*
            存取款业务：
            首先输入1表示办理存款业务，输入2表示办理取款业务
            进入取款业务后再输入存款和取款的具体金额，注意取款金额不能大于账户余额

        */
        int money = 10000; // 当前账户余额
        Scanner input = new Scanner(System.in);
        System.out.println("请选择办理业务，输入1办理存款业务，输入2办理取款业务。请输入：");
        int a = input.nextInt();
        if(a == 1 ){
            System.out.print("请输入存款金额：");
            int cq = input.nextInt();
            money = cq + money; // money += cq money = money + cq
            System.out.println("您的存款余额为" + money);
        }else {
            System.out.print("请输入取款金额：");
            int qq = input.nextInt();
            // 这里就是一个嵌套if选择结构
            if (qq>money){
                System.out.println("注意：您的取款金额不能大于账户余额");
            }else{
                money = money - qq; // money -= qq
                System.out.println("您的账户余额为：" + money);
            }
        }
    }
}
