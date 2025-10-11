package com.bing.p2;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * 字节文件输入流
 */
public class Test2 {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("file/test1.txt")){
            // 注意：这里的输入方向是从文件 输入到 程序
            // read方法，读取一个字节，返回的是字节编码
            System.out.println((char)inputStream.read());
            System.out.println((char)inputStream.read());
            // 如果读取不到信息，返回-1
            System.out.println(inputStream.read());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("------------");
        try(FileInputStream inputStream = new FileInputStream("file/test2.txt")){
            // 利用循环读取整个文件
            int tmp;
            // 每次读取一个字节，返回值不为-1就表示有内容
            while ((tmp = inputStream.read()) != -1){
                System.out.print((char)tmp);
            }
            System.out.println();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
