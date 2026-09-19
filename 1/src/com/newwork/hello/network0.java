package com.newwork.hello;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class network0 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 概述");
        // 网络编程：让设备上的程序与网络上的其他设备的程序进行数据交互（实现网络通信）
        // java实现网络编程都放到java.net.*包下的

        // 通信的基本架构：客户端-服务器架构（C/S架构） ； 浏览器-服务器架构（B/S架构）

        // 网络通信三要素：IP地址、端口号、协议
        // IP地址：唯一标识网络中的设备 ；(ipv4或ipv6 两种格式) ； ip分公网ip和内网ip
        // 端口号：标识设备上的应用程序 0-65535 ；常用端口号（0-1024） ；注册端口（1024-49151） ；动态端口（49152-65535），我们自己开发的程序一般用注册端口
        // 协议：规范设备间数据传输的规则 ，osi七层模型; tcp/ip四层模型

        // UDP：无连接、不可靠、速度快 ； TCP：面向连接、可靠、速度慢

        // 域名是代表ip的 通过dns转换为真实ip后 才能进行网络通信

        // ip相关操作
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("本机ip地址为：" + ip1.getHostAddress());
        System.out.println("本机主机名为：" + ip1.getHostName());

        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println("百度ip地址为：" + ip2.getHostAddress());
        System.out.println("百度主机名为：" + ip2.getHostName());

        System.out.println("测试百度是否可达：" + ip2.isReachable(3000)); // 判断百度是否可达 相当于ping

        System.out.println();
        System.out.println("3 UDP通信 一发一收");

        // 服务端为UdpS
        // DatagramSocket 类：数据报套接字，用于UDP发送和接收数据报
        // DatagramPacket 类：数据报包，用于存储发送或接收的数据报

//        // 1 创建客户端
//        DatagramSocket socket = new DatagramSocket();
//
//        // 2 创建数据报包
//        byte[] data = "hello world".getBytes();
//        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 6666);
//        // 四个参数 1 数据 2 数据长度 3 目的ip 4 目的端口
//
//        // 3 发送数据
//        socket.send(packet);
//        System.out.println("客户端数据已发送");
//        socket.close();

        System.out.println();
        System.out.println("3 UDP通信 多发多收");
        // 1 创建客户端
        DatagramSocket socket = new DatagramSocket();

        // 2 创建数据报包
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的数据：");
            String str = sc.nextLine();

            if (str.equals("exit")) {
                System.out.println("已退出");
                socket.close();
                break;
            }

            byte[] data = str.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 6666);
            // 四个参数 1 数据 2 数据长度 3 目的ip 4 目的端口

            // 3 发送数据
            socket.send(packet);
        }
        // 客户端多开 右上角小锤子右边下拉选择编辑配置   修改选项 点击允许多个实例 应用就行
        // 另外客户端不要绑定端口 用默认的配置 绑定端口会出现 多个程序端口冲突的情况
        // 此处多发多收代码的 客户端 可以多开

    }
}
