package com.bing.p2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 什么是IO，I->Input（输入） O->Output（输出），简言之：就是文件的输入和输出
 */
public class Test1 {
    public static void main(String[] args) {
        // 在java中IO又分为两大类：字节流 和 字符流
        // 字节流：是以字节为单位进行文件的读写操作
        // 字符流：是以字符为单位进行文件的读写操作

        // 字节流又分为：字节输入流 和 字节输出流

        // 这里我们创建一个字节文件输入流，初始化时必须要传一个路径（路径可以是绝对路径，也可以是相对路径）
        // 绝对路径：是相对于磁盘根路径的路径，比如：C:\a\b\c.txt
        // 相对路径：是相对于当前项目的根路径，注意：路径分隔符使用\\或者/，因为\是转义字符\\就是就转义后的\
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("file/test1.txt");
            // 中间会围绕流做一系列操作，问题时，它可能会发生异常
            // 如果把关闭流的代码放在try的最下面，是有肯能不执行的

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // finally中的代码，无论try是否发生异常，最后都会执行
            // 所以关闭流的操作，比较适合放置在这里面
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 通过观察上面的代码：它有两个的注意点：
        // 第一点：在try的外面把相关的流对象先定义好
        // 第二点：关闭流对象的方法，要继续使用try-catch进行保护
        System.out.println("-------------------------------------");
        // 可以使用try-with-resource语法对上面的代码结构进行简化
        try(FileInputStream inputStream1 = new FileInputStream("file/test1.txt")){
            // 在try的()里面创建，需要释放资源的对象，其实就是实现了Closeable接口的对象
            // 此时就不需要再通过finally代码块去手动释放资源了，因为try会自动帮我们释放资源
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
