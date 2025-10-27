package com.bing.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) throws UnknownHostException {
        /*
            网络三要素：
            1.IP地址，它是在网络上唯一区分一台服务器的标识
            2.端口，一台机器中会挂载很多应用，应用和应用之间使用端口区分
            3.协议：两台计算机在网络上传输数据，必须要遵守相关传输协议，常见的协议有两种（UDP协议和TCP协议）
            我们浏览网页使用的http协议底层使用的是TCP协议
        */
        /*
            如何查看本地IP
            ipconfig
            Mac电脑：ipconfig getifaddr en0/en1
            查看网络是否畅通
            ping IP地址/网址
        */
        // 获取当前主机的IP地址
        //getByName方法的参数：1.电脑的名字 2.具体的ip地址
        InetAddress address = InetAddress.getByName("192.168.6.199");
        // 获取主机名
        String name = address.getHostName();
        // 获取主机IP地址
        String ip = address.getHostAddress();
        System.out.println("主机名："+name);
        System.out.println("IP地址："+ip);
        // 端口号的取值范围：0–65535
        // UDP协议：用户数据协议（User Datagram Protocol）
        // 无连接通信协议，两台电脑不需要先建立连接就可以发送数据，通信效率高，速度快，数据包在传输过程中可能会部分缺损
        // 比如：视频、音频数据的传输采用的就是UDP协议，比如网络电话，视频都是采用UDP协议传输的
        // TCP协议：传输控制协议（Transmission control Protocl）
        // 面向连接的通信协议，两台电脑需要建立连接后才能收发数据，所以在TCP连接中存在客户端和服务器端
    }
}
