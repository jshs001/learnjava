package com.newwork.nw3;

import com.newwork.nw3.ServerReaderThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TcpS {
    public static List<Socket> onLineSockets = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        // ServerSocket
        // 1 创建ServerSocket对象 同时为服务端注册端口
        ServerSocket serverSocket = new ServerSocket(8888);

        // 2 使用ServerSocket对象 调用accept方法 等待客户端的连接

        while (true) {
            Socket socket = serverSocket.accept();
            onLineSockets.add(socket);
            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
            new ServerReaderThread(socket).start();
        }



    }
}
