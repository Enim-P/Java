package two;
import java.util.Scanner;
public class test12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = input.nextInt();
        System.out.print("请输入月份");
        int month = input.nextInt();

        if (month ==2){
            if (year%4==0&&year%100!=0||year%400==0){
                System.out.println(29);
            }else{
                System.out.println(28);
            }
        }else{
            switch(month){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println(31);
                    break;
                default:
                    System.out.println(30);
                }
            }
        }
    }


