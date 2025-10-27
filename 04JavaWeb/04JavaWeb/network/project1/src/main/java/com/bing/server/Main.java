package com.bing.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    // 运行服务端，在浏览器上输出http://ip地址:6003，此时当前浏览器流是客户端
    // http的底层协议就是TCP协议
    // 服务端接收到了浏览器端传过来的请求头信息
    // 服务端再给浏览器响应结果
    public static void main(String[] args) throws IOException {
        //1.创建服务端Socket对象
        ServerSocket serverSocket = new ServerSocket(6003);
        //2.监听客户端
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接，IP地址为："+
                socket.getInetAddress().getHostAddress());
        //3.读取客户端传递的所有数据
        System.out.println("接收到的客户端数据：");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        while (reader.ready()){
            System.out.println(reader.readLine());
        }
        // 4.服务端给客户端反馈
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        writer.write("HTTP/1.1 200 Accepted\r\n");
        writer.write("\r\n");
        writer.write("Hello World");
        writer.flush();
        //关闭资源
        serverSocket.close();
    }
}
