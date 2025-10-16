package two;

import java.util.Scanner;

/**
 * 练习
 */
public class test10 {
    public static void main(String[] args) {
        /*
            输入 年 月 日 ，计算出当前日期是全年的多少天
        */
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年:");
        int year = input.nextInt();
        System.out.print("请输入月:");
        int month = input.nextInt();
        System.out.print("请输入日:");
        int day = input.nextInt();
        /* int sum = 0; // 定义一个变量，用于接收总量
         我们将设输入的日期是2025年七月八日
         1. 将1月到6月所有的天数相加
         int i = 1;  //定义一个循环变量，值为1表示从一月份开始
         while(i<m) //i<m 表示i的最大值不能超过m,如果m是7，那么i的最大值值为6
            // i 此时代表的就是每个月份，所以要判断i是几，确定当前月份是多少天
            if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10){
                sum+=31;
            }else if(i==4||i==6||i==9||i==11){
            sum+=30;
            }
            if(year%4==0&&year%100!=0||year%400==0){
                sum += 29;
            }else{
                sum += 28;
            }
         i++;
         2. 将七月过去的天数相加
         sum += d;
         System.out.println(year+"年"+month+"月"+day+"日，是全年的第"+sum+"天");
         */

        int m = 1;
        int sumd = 0;
        while (m < month) {

                    if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                        sumd += 31;
                    } else if(m==4|| m==6|| m==9|| m==11){
                        sumd +=30;
                }else if(year%4==0&&year%100!=0||year%400==0) {
                        sumd+=29;
                    }else{
                        sumd+=28;
                    }
                m++;
            }int sum = sumd + day;
        System.out.println("当前天数是全年的第：" + sum + "天");
        }
    }

