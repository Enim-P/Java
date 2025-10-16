package com.bing.p2;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 追加写入
 */
public class Test5 {
    public static void main(String[] args) {
        // 在创建输出流的时候，构造方法的第二个参数可以设置，当前输出流是否是append写入
        try(FileOutputStream outputStream = new FileOutputStream("file/test4.txt",true)){
            // write方法，用于写入单个字节数据，如果写一个汉字，写进去的只是汉字的一半
            byte[] datas = "Hello World".getBytes();
            // 直接写入一个字节数组
            outputStream.write(datas);
            // 输出流，写完数据后，最后调用一下flush方法刷新操作，保证数据写完整
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
