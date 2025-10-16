package com.bing.p3;

import java.io.*;

/**
 * 字节缓冲流
 */
public class Test6 {
    public static void main(String[] args) {
        // 缓冲流需要普通流作为构造参数传入
        // 缓冲流默认有一个8192个字节的缓冲空间，在做读写大文件操作时性能更好
        // 用法跟普通流是一样的
        try(BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream("file/test1.txt")
        )){
            System.out.println((char)inputStream.read());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("-----------------------");
        try(BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream("file/test2.txt")
        )){
            outputStream.write("hello".getBytes());
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
