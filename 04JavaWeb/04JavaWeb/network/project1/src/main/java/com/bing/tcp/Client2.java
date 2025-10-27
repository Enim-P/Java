package com.bing.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// 客户端
public class Client2 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // 1.创建客户端的Socket对象
        // 需要指明服务器的ip地址和端口号
        Socket socket = new Socket("192.168.6.199",6003);
        while(true){
            // 2.向服务端写数据
            System.out.print("我：");
            String str = input.nextLine();
            OutputStream os = socket.getOutputStream();
            os.write(str.getBytes());
            if(str.equals("exit")){
                break;
            }
            // 3.接收服务端的反馈
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            String data = new String(bytes,0,len);
            if(data.equals("exit")){
                break;
            }
            System.out.println("陈伟霆："+data);
        }
        // 4.关闭资源
        socket.close();
    }
}
