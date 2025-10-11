package com.bing.p3;

import java.io.*;

/**
 * 字符缓冲流
 */
public class Test7 {
    public static void main(String[] args) {
        // 字符缓冲流内部默认有一个8192字符的缓冲空间，缓冲的空间通过构造方法的第二参数可以调整
        try(BufferedReader reader = new BufferedReader(
                new FileReader("file/test7.txt")
        )){
            // 读取一个字符
            //System.out.println((char) reader.read());
            //char[] str = new char[10];
            // 读取一个字符数组长度的内容
            //reader.read(str);
            //System.out.println(str);
            // 它有一个特有的方法readLine，表示读取一行数据
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("-------------------");
        try(BufferedReader reader = new BufferedReader(
                new FileReader("file/test11.txt")
        )){
            // 缓冲流的lines()方法，返回的使用一个Stream流
            // 有了Stream流，就可以通过Stream流的相关方法对数据做操作了
            reader.lines()
                    .distinct()
                    .sorted()
                    .skip(2)
                    .limit(4)
                    .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("-------------------");
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter("file/test12.txt")
        )){
            writer.write("你好");
            writer.newLine();    //换行
            writer.write("在干嘛");
            writer.newLine();
            writer.write("出来玩");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
