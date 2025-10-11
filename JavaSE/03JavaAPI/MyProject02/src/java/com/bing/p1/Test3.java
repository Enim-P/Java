package com.bing.p1;

import java.io.File;
import java.io.IOException;

/**
 * 编译时异常
 */
public class Test3 {
    public static void main(String[] args) {
        // 编译时异常，是java虚拟机在编译的时候提前抛出的异常，提醒程序员必须要对该异常提前做处理，因为它发生异常的概率较高
        File file = new File("my.txt");
        try{
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("程序继续往下执行...");

    }
}
