package two;

import java.util.Scanner;

/**
 * 练习
 * */
public class Test5 {
    public static void main(String[] args) {
        /*
         * 输入年份和月份输出该月份有多少天
         * */
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = input.nextInt();
        System.out.print("请输入月份：");
        int mouth = input.nextInt();
        boolean isLeetyear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        if (isLeetyear == true && mouth == 2) {
            System.out.println(29);

        } else {
            switch (mouth) {
                case 1:
                    System.out.println(31);
                    break;
                case 2:
                    System.out.println(28);
                    break;
                case 3:
                    System.out.println(31);
                    break;
                case 4:
                    System.out.println(30);
                    break;
                case 5:
                    System.out.println(31);
                    break;
                case 6:
                    System.out.println(30);
                    break;
                case 7:
                    System.out.println(31);
                    break;
                case 8:
                    System.out.println(31);
                    break;
                case 9:
                    System.out.println(30);
                    break;
                case 10:
                    System.out.println(31);
                    break;
                case 11:
                    System.out.println(30);
                    break;
                case 12:
                    System.out.println(31);
                    break;
                default:
                    System.out.println("错误的月份");
            }
        }
        System.out.println("---------------");
        switch (mouth){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(30);
            default:
                if (isLeetyear == true)
                    System.out.println(29);
                else
                    System.out.println(28);
        }
    }
}



