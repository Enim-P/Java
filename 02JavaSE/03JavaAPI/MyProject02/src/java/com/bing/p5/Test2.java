package com.bing.p5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 打印流
 */
public class Test2 {
    public static void main(String[] args) {
        // System.out就是一个打印流（PrintStream）
        // 它的println方法，用于在控制台打印
        System.out.println("哈哈哈哈哈");
        System.out.println("--------------");
        // 也可以使用打印流，向文件中打印
        try(PrintStream stream = new PrintStream(
                new FileOutputStream("file/test13.txt")
        )){
            stream.println("哈哈哈哈哈");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
