package com.bing.p3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 拷贝一个中文文件
 */
public class Test3 {
    public static void main(String[] args) {
        // 使用字符流，将test9.txt复制一份给test10.txt
        try(FileReader reader = new FileReader("file/test9.txt");
            FileWriter writer = new FileWriter("file/test10.txt")){
            char[] str = new char[50];
            int tmp;
            while ((tmp=reader.read(str))!=-1){
                writer.write(str,0,tmp);
            }
            writer.flush();
            System.out.println("复制成功！");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
