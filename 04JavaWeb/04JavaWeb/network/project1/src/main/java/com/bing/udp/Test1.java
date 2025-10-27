package com.bing.udp;

import java.io.IOException;
import java.net.*;

// UDP发送端
public class Test1 {
    public static void main(String[] args) throws IOException {
        //1. 创建发送端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket();
        //2. 创建数据，并将数据打成字节数组包
        String str = "hello！欢迎光临！";
        byte[] bytes = str.getBytes();
        //3. 通过DatagramSocket对象的send方法发送数据
        //send放大的参数是DatagramPacket对象，需要发送的数据包
        //DatagramPacket对象在构造的时候需要传递4个参数：
        //1.数据包 2.数据包长度 3.接受方的IP地址 4.接收方的端口号
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,
                InetAddress.getByName("192.168.6.199"),8001);
        ds.send(dp);
        //4. 关闭发送端
        ds.close();
    }
}
