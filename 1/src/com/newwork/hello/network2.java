package com.newwork.hello;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class network2 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 tcp支持多个客户端");
        // 上一节的tcp服务端 只能接收一个tcp客户端 因为 tcp的连接是可靠性 稳定性的
        // 所以需要使用多线程来实现多个客户端同时连接

        // java.net.Socket

        // 1 创建socket对象 同时请求与服务端程序的连接
        Socket socket = new Socket("127.0.0.1", 8888);

        // 2 从socket通信管道中得到一个字节输出流，用来发数据给服务端程序
        OutputStream os = socket.getOutputStream();

        // 3 把字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        // 4 开始写数据出去了 关闭资源
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            String s = sc.nextLine();

            if (s.equals("exit")){
                System.out.println("退出循环");
                sc.close();
                dos.close();
                socket.close();
                break;
            }


            dos.writeUTF(s);
            dos.flush();
        }


















    }
}
