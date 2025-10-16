package com.bing.school.p3;

public class Test {
    public static void main(String[] args) {
        test(new String[]{"你好","在吗","在干嘛","哈哈"});
        System.out.println("================");
        // 调用可变参数的方法时，参数可以传数组，也可以使用下面的方式
        test("你好","在吗","在干嘛","哈哈");
    }

    // 可变参数
    static void test(String... args){
        System.out.println(args[0]);
        System.out.println();
        for (String s : args){
            System.out.println(s);
        }
    }
}
