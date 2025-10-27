package com.bing.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// UDP接收端
public class Test2 {
    public static void main(String[] args) throws IOException {
        //1. 创建接收端的Socket对象(DatagramSocket)，这里要明确接收端的端口号
        DatagramSocket ds = new DatagramSocket(8001);
        //2. 创建一个数据包，用于接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        //3. DatagramSocket对象的receive方法接收数据
        ds.receive(dp);
        //4. 解析数据包里面的数据
        String str = new String(dp.getData(),0,dp.getLength());
        System.out.println("接收到的数据是："+str);
        //5. 关闭接收端
        ds.close();
    }
}
