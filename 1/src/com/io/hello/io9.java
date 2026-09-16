package com.io.hello;

import com.io.io9.User;

import java.io.*;

public class io9 {
    public static void main(String[] args) {
        System.out.println("1 数据流");
        // DataOutputStream：允许把数据和其类型一并写出去
        // DataInputStream：读取数据输出流写出去的数据

        try(
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("1/src/com/io/io9/test.txt"));
                ) {
            dos.writeInt(100);
            dos.writeDouble(10.0);
            dos.writeBoolean(true);
            dos.writeUTF("你好"); // 写出去的数据 不是为了给你看的

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("1/src/com/io/io9/test.txt"));){
            int i = dis.readInt();
            System.out.println(i);
            double d = dis.readDouble();
            System.out.println(d);
            boolean b = dis.readBoolean();
            System.out.println(b);
            String s = dis.readUTF();
            System.out.println(s);
            // 读的时候一定要保持这个顺序 否则报错
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("2 序列化流");
        // 对象序列化：把java对象写到文件中
        // 对象反序列化：从文件中读取java对象

        // ObjectInputStream：从文件中读取java对象
        // ObjectOutputStream：把java对象写到文件中

        try(
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("1/src/com/io/io9/test1.txt"));
                ) {
            User u = new User("admin", "张三", 18, "1231gasdg");
            oos.writeObject(u);
            System.out.println("序列化成功"); // 对象必须实现 Serializable接口

        }catch (Exception e) {
            e.printStackTrace();
        }


        try(
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("1/src/com/io/io9/test1.txt"));
                ) {
            User u = (User) ois.readObject();
            System.out.println(u);
            System.out.println("反序列化成功");

        }catch (Exception e) {
            e.printStackTrace();
        }


        // 如果一次要序列化多个对象 怎么办
        // 可以用一个Arraylist集合来存储多个对象,然后直接对集合进行序列化即可
        // 注意：ArrayList集合已经实现了序列化接口






















    }

}
