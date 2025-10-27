package com.bing.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

// TCP发送端（客户端）
public class Test1 {
    public static void main(String[] args) throws IOException {
        //1. 创建客户端的Socket对象
        //指明服务端的IP地址和端口号
        Socket socket = new Socket("192.168.6.199",6001);
        //2. 获取一个输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("你好！欢迎光临！".getBytes());
        //3. 释放资源
        socket.close();
    }
}
