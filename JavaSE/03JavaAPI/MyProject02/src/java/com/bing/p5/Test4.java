package com.bing.p5;

import java.io.*;

/**
 * 对象流
 */
public class Test4 {
    public static void main(String[] args) {
        // 对象流：用于序列化对象，序列化就是将一个完整对象以文件流的方式进行保存
        // 返序列化就是将一个序列化后的文件重新转为程序中的对象
        // ObjectOutputStream对象输出流，用于序列化对象
        try(ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("file/test15.txt")
        )){
            // 创建了一个对象
            Student s = new Student("1001","王杰",20);
            // writeObject方法，用于序列化对象
            outputStream.writeObject(s);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("-----------------------");
        // ObjectInputStream对象输入流，用于返序列化对象
        try(ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("file/test15.txt")
        )){
            // readObject方法，用于返序列化对象
            Student s = (Student)inputStream.readObject();
            System.out.println(s);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
