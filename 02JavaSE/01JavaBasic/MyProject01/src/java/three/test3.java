package three;

import java.util.Scanner;

/**
 * 菜单结果练习
 */
public class test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*
           系统菜单的结构： 1.添加 2.修改 3删除 4查询 0退出
        */
        int no = 0 ;
        // 因为这个循环体的第一次无论如何都要执行，所以最佳方案是使用do-while循环
        do{
            System.out.println("请输入操作(1添加、2修改、3删除、4查询、0退出)：");
            no = input.nextInt();
            if(no==1){
                System.out.println("执行添加相关操作...");
            }else if(no==2){
                System.out.println("执行修改相关操作...");
            }else if(no==3){
                System.out.println("执行删除相关操作...");
            }else if(no==4){
                System.out.println("执行查询相关操作...");
            }else if(no==0){
                System.out.println("成功退出...");
            }else{
                System.out.println("输入错误...");
            }
        }while(no != 0);

    }
}
