package com.bing.p3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 写入流
 */
public class Test2 {
    public static void main(String[] args) {
        // FileWriter是文件写入流，其实就是字符输出流，对应的字节输出流是FileOutputStream
        // FileWriter的构造方法的第二个参数设置为true，表示追加写入
        try(FileWriter writer = new FileWriter("file/test8.txt",true)){
            // 获取文件的编码类型
            System.out.println(writer.getEncoding());
            writer.write('哈');  //可以写入一个字符
            writer.write("哈哈");  //可以写入一个字符串
            // append方法的功能跟write方法是一样的，都是写入内容
            // append可以链式调用
            writer.append("呵呵").append("嘻嘻").append("在吗");
            writer.write("\n");   //写入换行符
            writer.flush();   //写完后通常需要先刷新
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
