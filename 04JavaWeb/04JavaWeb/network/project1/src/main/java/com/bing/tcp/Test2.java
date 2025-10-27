package com.bing.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP接收端（服务端）
public class Test2 {
    public static void main(String[] args) throws IOException {
        //1. 创建服务端Socket对象(ServerSocket)
        // 指明当前服务端的端口号
        ServerSocket serverSocket = new ServerSocket(6001);
        //2. 监听客户端连接，返回一个Socket对象
        Socket socket = serverSocket.accept();
        //3. 获取输入流，读数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes,0,len);
        System.out.println("客户端发送的数据是："+data);
        //4. 释放资源
        serverSocket.close();
    }
}
