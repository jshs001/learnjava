package com.newwork.nw3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReaderThread extends Thread {
    private Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 3 从socket通信管道中得到一个字节输入流，用来读取客户端发过来的数据
            InputStream is = socket.getInputStream();

            // 4 把原始的字节输入流包装成数据输入流 并使用数据输入流 读取客户端发过来的数据
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                try {
                    String rs  = dis.readUTF();
                    System.out.println(rs);
                    sendMsgToAll(rs);
                } catch (IOException e) {
                    System.out.println("有人下线了：" + socket.getRemoteSocketAddress()  );
                    TcpS.onLineSockets.remove(socket);
                    dis.close();
                    socket.close();
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void sendMsgToAll(String rs) throws Exception {
        for (Socket socket : TcpS.onLineSockets) {

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(rs);
        }
    }
}
