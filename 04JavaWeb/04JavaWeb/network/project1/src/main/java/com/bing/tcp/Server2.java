package com.bing.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 服务端
public class Server2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // 1.创建服务端的Socket对象
        // 这里需要指明服务端的端口号
        ServerSocket serverSocket = new ServerSocket(6003);
        // 2.监听客户端连接，返回客户端Socket对象
        Socket socket = serverSocket.accept();
        while (true){
            // 3.拿到客户端写的数据
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            String data = new String(bytes,0,len);
            if(data.equals("exit")){
                break;
            }
            System.out.println("赵露思："+data);
            // 4.给客户端反馈
            OutputStream os = socket.getOutputStream();
            System.out.print("我：");
            String str = input.nextLine();
            os.write(str.getBytes());
            if(str.equals("exit")){
                break;
            }
        }
        // 5.释放资源
        serverSocket.close();
    }
}
