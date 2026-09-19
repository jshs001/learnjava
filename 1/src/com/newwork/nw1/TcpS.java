package com.newwork.nw1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpS {
    public static void main(String[] args) throws Exception {
        // ServerSocket
        // 1 创建ServerSocket对象 同时为服务端注册端口
        ServerSocket serverSocket = new ServerSocket(8888);

        // 2 使用ServerSocket对象 调用accept方法 等待客户端的连接
        Socket socket = serverSocket.accept();

        // 3 从socket通信管道中得到一个字节输入流，用来读取客户端发过来的数据
        InputStream is = socket.getInputStream();

        // 4 把原始的字节输入流包装成数据输入流 并使用数据输入流 读取客户端发过来的数据
        DataInputStream dis = new DataInputStream(is);
        String rs = dis.readUTF();
        System.out.println(rs);
        System.out.println("获取客户端地址：" + socket.getRemoteSocketAddress());

        dis.close();
        socket.close();



    }
}
