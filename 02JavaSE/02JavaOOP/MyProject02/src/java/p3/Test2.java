package p3;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入消费金额：");
        String s = input.next();
        // 对输入的字符串金额，添加千位符
        // 比如输入的是：123456789，转为123,456,789
        StringBuilder s2 = new StringBuilder(s);
        for(int i=s2.length()-3;i>0;i-=3){
            s2.insert(i,",");
        }
        System.out.println(s2);
    }
}
