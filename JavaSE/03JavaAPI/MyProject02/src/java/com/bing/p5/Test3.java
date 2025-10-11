package com.bing.p5;

import java.io.*;

/**
 * 数据流
 */
public class Test3 {
    public static void main(String[] args) {
        // DataOutputStream：数据输出流
        try(DataOutputStream outputStream = new DataOutputStream(
                new FileOutputStream("file/test14.txt")
        )){
            // 可以直接输出程序中的基本类型数据
            // 写入的是二进制数据
            outputStream.writeInt(100);
            outputStream.writeBoolean(true);
            outputStream.writeDouble(55.55);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        try(DataInputStream inputStream = new DataInputStream(
                new FileInputStream("file/test14.txt")
        )){
            // 可以读取写入的对应数据
            // 将二进制数据转回输入时的数据
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readDouble());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
