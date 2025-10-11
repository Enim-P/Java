package p2;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一个邮箱：");
        String email = input.next();
        // 判断输入的邮箱格式是否正确
        // xxx@xxx.com 或 xxx@xxx.cn
        // 邮箱中必须包含@字符,必须以.com或.cn结尾，@字符不能是第一位，.字符必须在@字符的后面，而且中间至少隔一位
        // 1.找到@符号的位置
        int index1 = email.indexOf("@");
        // 2.找到最后一个.符号的位置
        int index2 = email.lastIndexOf(".");
        // 3.判断@符号的位置要大于0，最后一个.符号的位置要大于@符号的位置+1
        if(index1>0 && index2>index1+1){
            // 4.判断最后一个.符号后面的内容是不是com或cn
            String last = email.substring(index2);
            if(last.equals(".com") || last.equals(".cn")){
                System.out.println("邮箱格式正确");
            }else{
                System.out.println("邮箱格式错误");
            }
        }else{
            System.out.println("邮箱格式错误");
        }
    }
}
