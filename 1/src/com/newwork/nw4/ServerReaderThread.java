package com.newwork.nw4;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReaderThread extends Thread {
    private Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(os);
//            dos.writeUTF("服务器欢迎你！");
            // 服务器必须给浏览器响应http协议 否则访问不了
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/html; charset=UTF-8");
            ps.println(); // 必须换行
            ps.println("<h1>服务器欢迎你！</h1>");


            ps.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
