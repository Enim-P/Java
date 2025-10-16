package four;

import java.util.Scanner;

/**
 * 练习
 */
public class test8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
          /*
            打印菱形
            从控制台输入菱形的行数，如果是偶数，提醒用户必须更具奇数，如果是奇数打印对应的菱形
            ###*
              ***
             *****
            *******
             *****
              ***
               *
        */
        System.out.println("请输入想要的实行的菱形的行数：");
        int linenumber = input.nextInt();
        if(linenumber%2==0){
            System.out.println("对不起，请输入奇数行");
        }
            for (int i = 1; i <= ((linenumber+1)/2); i++) {
                for (int a = ((linenumber+1)/2); a-i>=0; a--) {
                    System.out.print(" ");
                    }
                for(int b = 1; b<=i*2-1; b++){
                        System.out.print("*");
                }
                System.out.println();
            }
        for (int i = 1; i <= (linenumber/2); i++) {
            for (int a = 0; a<=i; a++) {
                System.out.print(" ");
            }
            for(int b = 1; b<=(linenumber-i*2); b++){
                System.out.print("*");
            }
            System.out.println();
        }

           /* 打印空心菱形，同上
               *
              * *
             *   *
            *     *
             *   *
              * *
               *
        */
        System.out.println("请输入想要的实行的菱形的行数：");
        int linenumber2 = input.nextInt();
        if(linenumber2%2==0){
            System.out.println("对不起，请输入奇数行");
            linenumber2 =input.nextInt();
        }else {
            for (int i = 1; i <= ((linenumber2 + 1) / 2); i++) {
                for (int a = ((linenumber2 + 1) / 2); a - i > 0; a--) {
                    System.out.print(" ");
                }
                for (int b = i; b <= i; b++) {
                    System.out.print("*");
                }
                if (i != 1) {
                    for (int c = 1; c <= i * 2 - 3; c++) {
                        System.out.print(" ");
                    }
                }
                if (i != 1) {
                    for (int d = i; d <= i; d++) {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
            for (int i = 1; i <= (linenumber2 / 2); i++) {
                for (int a = 1; a <= i; a++) {
                    System.out.print(" ");
                }
                for (int b = i; b <= i; b++) {
                    System.out.print("*");
                }
                if (i != 3) {
                    for (int c = 1; c <= linenumber2 - (i * 2) - 2; c++) {
                        System.out.print(" ");
                    }
                }
                if (i != 3) {
                    for (int b = i; b <= i; b++) {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
        }



        /*
            百钱买百鸡：公鸡五文钱，母鸡三文钱，小鸡一文钱三只，请问公鸡、母鸡、小鸡各多少只
        */

            for(int a=0;a<=20;a++ ){
                for(int b=0;b<=33;b++){
                    for(int c=0;3*c<=300;c++){
                        if(a+b+3*c==100&&a*5+b*3+c*1==100){
                            System.out.println("公鸡"+a+"只，母鸡"+b+"只，小鸡"+c+ "只。");
                            }
                        }
                    }
                }
            }
    }

