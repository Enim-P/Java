package com.bing.p2;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节文件输出流
 */
public class Test4 {
    public static void main(String[] args) {
        // 注意：这里的输出方向是从程序 输出到 文件
        // 注意：输出流在创建的时候，如果指定的文件不存在，它会帮我们创建这个文件
        try(FileOutputStream outputStream = new FileOutputStream("file/test3.txt")){
            // write方法，用于写入单个字节数据，如果写一个汉字，写进去的只是汉字的一半
            outputStream.write('a');
            byte[] datas = "Hello World".getBytes();
            // 直接写入一个字节数组
            outputStream.write(datas);
            byte[] datas2 = "ABCDEFG".getBytes();
            // 跳过字节数组的前2个空间，再取字节数组的后2个空间的数据写入
            outputStream.write(datas2,2,2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
