package com.bing.p2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 拷贝操作
 */
public class Test6 {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("file/test5.txt");
            FileOutputStream outputStream = new FileOutputStream("file/test6.txt")){
            byte[] bytes = new byte[50];   //定义一个长度为50的字节数组，用于流之间数据传递
            int tmp;   //每次读取的长度，返回-1表示读取完毕
            while ((tmp=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,tmp);
            }
            outputStream.flush();
            System.out.println("文件复制成功！");
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("---------------");
        try(FileInputStream inputStream = new FileInputStream("file/a.png");
            FileOutputStream outputStream = new FileOutputStream("file/b.png")){
            byte[] bytes = new byte[50];   //定义一个长度为50的字节数组，用于流之间数据传递
            int tmp;   //每次读取的长度，返回-1表示读取完毕
            while ((tmp=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,tmp);
            }
            outputStream.flush();
            System.out.println("文件复制成功！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
