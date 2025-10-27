package com.bing.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 服务端
public class Server {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // 1.创建服务端的Socket对象
        // 这里需要指明服务端的端口号
        ServerSocket serverSocket = new ServerSocket(6002);
        // 2.监听客户端连接，返回客户端Socket对象
        Socket socket = serverSocket.accept();
        // 3.拿到客户端写的数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        String data = new String(bytes,0,len);
        System.out.println("客户端写的数据是："+data+"\n");
        // 4.给客户端反馈
        OutputStream os = socket.getOutputStream();
        System.out.print("给客户端反馈：");
        String str = input.next();
        os.write(str.getBytes());
        // 5.释放资源
        serverSocket.close();
    }
}
