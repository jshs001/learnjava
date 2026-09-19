package com.newwork.hello;

import com.newwork.nw4.ServerReaderThread;
import com.newwork.nw4.ServerReaderThread1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class network4 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 BS架构");

//        ServerSocket serverSocket = new ServerSocket(8080);
//
//
//
//        while (true) {
//            Socket socket = serverSocket.accept();
//            System.out.println("有人上线了：" + socket.getRemoteSocketAddress());
//
//            new ServerReaderThread(socket).start();
//        }

// 服务器必须给浏览器响应http协议 否则访问不了

        System.out.println();
        System.out.println("2 线程池优化");



        ServerSocket serverSocket = new ServerSocket(8080);

        // 线程池优化
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new ServerReaderThread1(socket));
        }


















    }
}
