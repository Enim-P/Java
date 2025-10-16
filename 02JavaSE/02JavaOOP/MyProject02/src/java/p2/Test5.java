package p2;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入原始字符串：");
        String str = input.next();
        System.out.print("请输入查找字符串：");
        String s = input.next();
        int count = 0;  //表示次数
        // 比如：str="abcddabcddabcddabc"
        //      s="dd"
        int index = str.indexOf(s);  //先查找一次
        while(index!=-1){
            count++;   //次数加1
            // 去掉上一次查找结果前面的内容
            str = str.substring(index+s.length());
            index = str.indexOf(s);  //继续查找
        }
        System.out.println(String.format("%s 在原始字符串中出现了 %s次",s,count));
    }
}
