package com.newwork.nw2;

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

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            new ServerReaderThread(socket).start();



        }



    }
}
