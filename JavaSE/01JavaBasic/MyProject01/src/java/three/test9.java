package three;

import java.util.Scanner;

/**
 * 练习
 */
public class test9 {
    public static void main(String[] args) {
        /*
            输入你出生的年月日，在输入当前日期的年月日，计算你活了多少天  todo 这里有bug,如果出生年和现在是时间再同一年计算会重复
            1. 计算出出身那一天还剩下多少天
            2. 计算出中间还有多少个整年
            3. 计算今年已经过去了多少天
        */
        Scanner input = new Scanner(System.in);
        System.out.println("请输入出生的年份：");
        int year = input.nextInt();
        System.out.println("请输入出身的月份：");
        int month = input.nextInt();
        System.out.println("请输入出生的日：");
        int day = input.nextInt();
        System.out.println("请输入现在的年份：");
        int year2= input.nextInt();
        System.out.println("请输入现在的月份：");
        int month2 = input.nextInt();
        System.out.println("请输入现在的日：");
        int day2 = input.nextInt();
        int oldSum = 0; // oldSum代表出生那一年剩下的天数
        for(int a = 12; a>month; a--){
            if(a==1||a==3||a==5||a==7||a==8||a==10||a==12){
                oldSum +=31;
            }else if (a==4||a==6||a==9||a==11){
                oldSum +=30;
            }
            if(a==2){
                if(year%4==0&&year%100!=0||year%400==0){
                oldSum +=29;
            }else{
                oldSum +=28;}
            }
        }
        int monthlast = 0; // mothlast 代表出生那个月剩余天数
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            monthlast = 31-day;
        }else if(month==4||month==6||month==9||month==11){
            monthlast = 30 -day;
        }else if(month==2){
            if(year%4==0&&year%100!=0||year%400==0){
                monthlast = 29-day;
            }else{
                monthlast = 28 -day;
            }
        }
        System.out.println("之前的天数"+ (oldSum+monthlast));


        int betweenSum = 0; // betweenSum代表中间的天数
            for(int year3 = (year+1); year3<year2;year3++){
                if(year3%4==0&&year3%100!=0||year3%400==0){
                    betweenSum += 366;
                }else{
                    betweenSum += 365;
                }
            }

        System.out.println("中间的天数："+ betweenSum);

        int c = 1;
        int nowSum = 0; // nowSum代表今年的天数
        while(c<month2){
            if(c==1||c==3||c==5||c==7||c==8||c==10||c==12){
                nowSum +=31;
            }else if (c==4||c==6||c==9||c==11){
                nowSum +=30;
            }
            if(c==2){
                if(year2%4==0&&year2%100!=0||year2%400==0){
                nowSum +=29;
            }else{
                nowSum +=28;
                }
            }
            c++;
    }
            System.out.println("今年已经过去了"+(nowSum+day2)+"天");
            System.out.println("您已经活了："+(oldSum+betweenSum+nowSum));
}
}
