package two;

import java.util.Scanner;

/**
 * switch选择结构
 * */
public class Test4 {
    public static void main(String[] args) {
        /*
            请输入你的考试名次：
            1-> 奖励苹果手机
            2-> 奖励华为平板
            3-> 奖励小米手表
            4-> 奖励三星耳机
            否则没有奖励
        * */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你的名次：");
        int No = input.nextInt();
        if (No == 1){
            System.out.println("奖励苹果手机");
        }else if(No == 2){
            System.out.println("奖励华为平板");
        }else if(No == 3 ){
            System.out.println("奖励小米手表");
        }else if (No == 4){
            System.out.println("奖励三星耳机");
        }else{
            System.out.println("没有奖励");
        }
        System.out.println("-------------");
        // 当多重判断的条件都是等值判断时，可以使用switch选择结构简化多重if选择结构
        // 将判断的变量放置在（）里面
        switch(No){
            //case 后面的值会跟（）里面的变量进行等值判断，如果相等就执行case里面定义的语句
            case 1:
                System.out.println("奖励苹果手机");
                // case语句必须要以break结尾
                //如果当前case成立了，会继续跳过判断执行下面case的语句，直到遇到break
                break;
            case 2 :
                System.out.println("奖励华为平板");
                break;
            case 3:
                System.out.println("奖励小米手表");
                break;
            case 4:
                System.out.println("奖励三星耳机");
                break;
                // 如果所有的case都不成立，最后执行default
            default:
                System.out.println("没有奖励");
        }
        // 总结：多重if选择结构常用于判断区间值，switch选择结构用于判断固定值。
    }
}
