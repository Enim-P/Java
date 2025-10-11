package com.bing.p3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 拷贝文件夹
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        // 将文件夹one里面的所有内容复制到文件夹two中
        copy(new File("one"),"two");
    }

    // 复制文件夹的方法
    private static void copy(File file,String to){
        File target = new File(to);
        // 如果目标文件夹不存在，创建目标文件夹
        if(!target.exists()){
            target.mkdir();   //创建目标文件夹
        }
        to = to+"/";    //目标路径
        // 判断File对象是不是文件夹
        if(file.isDirectory()){
           // 获取指定文件夹下面的所有文件
           File[] files = file.listFiles();
           for(File f : files){
               // 判断f是不是文件夹
               if(f.isDirectory()){
                   copy(f,to+f.getName());   //使用递归进行深度拷贝
               }else{
                   try(FileReader reader = new FileReader(f);
                       FileWriter writer = new FileWriter(to+f.getName())){
                       char[] str = new char[50];
                       int tmp;
                       while((tmp= reader.read(str))!=-1){
                           writer.write(str,0,tmp);
                       }
                   }catch (IOException e){
                       e.printStackTrace();
                   }
               }
           }
        }
    }
}
