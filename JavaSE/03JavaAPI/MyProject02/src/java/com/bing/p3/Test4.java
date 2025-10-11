package com.bing.p3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * File类
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        // File类专门用于表示一个文件或文件夹
        File file = new File("my.txt");
        if(!file.exists()){
            // 创建文件
            file.createNewFile();
        }

        File file1 = new File("file/test10.txt");
        System.out.println(file1.exists());  //判断文件是否存在
        System.out.println(file1.length());  //获取文件大小，返回的是字节数
        System.out.println(file1.isDirectory());  //判断是否是文件
        System.out.println(file1.canRead());   //是否可读
        System.out.println(file1.canWrite());   //是否可写
        System.out.println(file1.canExecute());  //是否可执行
        System.out.println(file1.getName());    //获取文件名
        System.out.println(file1.getPath());    //获取文件的相对路径
        System.out.println(file1.getParent());  //获取文件的父级路径
        System.out.println(file1.getAbsoluteFile());  //获取绝对文件
        System.out.println(file1.getAbsolutePath());  //获取文件的绝对路径

        System.out.println("------------------------");
        File file2 = new File("file");   //现在File对象表示一个文件夹
        String[] list = file2.list();   //返回文件夹下所有文件名称的数组
        System.out.println(Arrays.toString(list));
        File[] files = file2.listFiles();  //返回文件夹下所有文件的数组
        // 遍历所有文件
        for(File f : files){
            // 查看每个文件的绝对路径
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("------------------------");
        File file3 = new File("file/test10.txt");
        // 可以直接将File对象作为字节流或字符流的构造参数
        FileInputStream inputStream = new FileInputStream(file3);
        System.out.println(inputStream.read());
        FileReader reader = new FileReader(file3);
        System.out.println(reader.read());
    }
}
