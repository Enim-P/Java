package com.bing.p3;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符流：以字符为单位进行读写操作
 */
public class Test1 {
    public static void main(String[] args) {
        // FileReader(文件读取流)，其实就是字符输入流 跟字节输入流FileInputStream对应
        try(FileReader reader = new FileReader("file/test7.txt")){
            // 跳过指定的字符
            reader.skip(2);
            // 一次读取一个字符，是从指定的文件 读到 程序中
            System.out.println((char) reader.read());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("-----------------");
        try(FileReader reader = new FileReader("file/test7.txt")){
           char[] str = new char[10];
           // 直接读取到字符数组中
           reader.read(str);
           System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
