package com.bing.p2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 批量读取数据
 */
public class Test3 {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("file/test2.txt")){
            // available方法，返回文件的字节总算的预估值
            //System.out.println(inputStream.available());
            // 定义一个字节数组
            byte[] bytes = new byte[inputStream.available()];
            // read方法，可以传递一个字节数组，表示一次性将该字节数组填满，返回值是读取的长度
            int read = inputStream.read(bytes);
            System.out.println(read);
            System.out.println(new String(bytes));
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("----------------------");
        try(FileInputStream inputStream = new FileInputStream("file/test2.txt")){
            // available方法，返回文件的字节总算的预估值
            //System.out.println(inputStream.available());
            // 定义一个字节数组
            byte[] bytes = new byte[inputStream.available()];
            // skip方法，表示跳过的字节数
            inputStream.skip(3);
            // 这里的2表示跳过数组的前2个空间，4表示填充数组的4个空间
            int read = inputStream.read(bytes,2,4);
            System.out.println(read);
            System.out.println(new String(bytes));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
