package p2;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // String类型
        // String是引用类型，所有的引用类型都必须要创建（也就是要new）
        // 如果你直接定义一个String类型的变量，其实是编译器在帮我们new
        // 当然你也可以自己new
        // 手动创建的第一个String对象
        String s1 = new String("hello");
        // 手动创建的第二个String对象
        String s2 = new String("hello");
        System.out.println(s1);
        System.out.println(s2);
        // == 比较的是字符串的地址
        System.out.println(s1==s2);
        // equals方法是比较字符串的值
        System.out.println(s1.equals(s2));
        System.out.println("--------------------");
        // 1.编译发现你没有new，它帮你new一下
        String s3 = "hello";
        // 2.编译器又发现你还是没new，而且值跟上一次一样，上一次我已经帮你new过了，它就直接把上一次的地址复制给它
        String s4 = "hello";
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
        System.out.println("--------------------");
        System.out.print("请输入第一个String：");
        // 如果程序在运行时直接定义字符串，每次都是创建新的堆空间存储
        String s5 = input.next();
        System.out.print("请输入第二个String：");
        String s6 = input.next();
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s5==s6);
        System.out.println("--------------------");
    }
}
