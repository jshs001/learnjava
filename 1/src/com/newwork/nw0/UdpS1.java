package com.newwork.nw0;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpS1 {
    public static void main(String[] args) throws Exception {
        // 1 创建服务端对象
        DatagramSocket socket = new DatagramSocket(6666);

        // 2 创建数据包对象 用于接数据
        byte[] buffer = new byte[1024*64]; //64KB
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            // 3 接收数据
            socket.receive(packet);

            // 4 打印接收的数据
            int len = packet.getLength();

            String rs = new String(buffer, 0, len);
            System.out.println("接收数据为：" + rs);
//            System.out.println("客户地址为：" + packet.getAddress().getHostAddress());
//            System.out.println("客户端口号为：" + packet.getPort());
            System.out.println("---------------------------------");
        }
    }
}
