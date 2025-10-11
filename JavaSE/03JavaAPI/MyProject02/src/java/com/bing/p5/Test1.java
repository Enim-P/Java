package com.bing.p5;

import java.io.*;

/**
 * 转换流：将字节流转换成字符流
 */
public class Test1 {
    public static void main(String[] args) {
        // OutputStreamWriter字符写入流的构造方法，接收一个字节流参数
        try(OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("file/test2.txt")
        )){
            writer.write("可以直接写字符串了");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("---------------");
        // InputStreamReader字符读取流的构造方法，接收一个字节流参数
        try(InputStreamReader reader = new InputStreamReader(
                new FileInputStream("file/test2.txt")
        )){
            System.out.println((char) reader.read());
        }catch (IOException e){
            e.printStackTrace();
        }
        // 总结：在已经有字节流的情况下下，需要将字节流转为字符流时，使用这两种流。
        // 比如调用一个方法，方法返回了一个字节流，而我们需要使用字符流操作，这种情况下会使用上面的两种流
    }
}
