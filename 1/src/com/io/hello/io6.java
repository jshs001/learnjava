package com.io.hello;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class io6 {
    public static void main(String[] args) {
        System.out.println("1 字节缓冲流");
        // 原始流是低级流 包装流是处理流
        // 缓冲流 对原始流进行包装，以提高原始流读写数据的性能

        // 假如d盘的一个文件16KB 字节输入缓存流缓存8KB 读取文件数据到内存中 内存是1KB的数组 字节输出缓存流也是8KB 写入文件到C盘
        // io开销一共是4次 读两次写两次（磁盘到缓存再到内存 或 内存到缓存再到磁盘）    内存开销忽略不计 因为内存非常快


        try(
                InputStream is = new FileInputStream("1/src/com/io/io6/test.txt");
                OutputStream os = new FileOutputStream("1/src/com/io/io6/test1.txt");
                BufferedInputStream bis = new BufferedInputStream(is); // 包装字节缓冲输入流 默认自带8KB的缓冲池 也可以自定义缓冲池大小
                BufferedOutputStream bos = new BufferedOutputStream(os); // 包装字节缓冲输出流
                ){

            byte[] b = new byte[1024];
            int len;
            while((len = bis.read(b)) != -1){
                bos.write(b,0,len);
            }
            System.out.println("复制完成");

        }catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("2 字符缓冲流");
        try(
                Reader reader = new FileReader("1/src/com/io/io6/test.txt");
                Writer writer = new FileWriter("1/src/com/io/io6/test1.txt");
                BufferedReader br = new BufferedReader(reader); // 包装字符缓冲输入流 默认自带8KB的缓冲池 也可以自定义缓冲池大小
                BufferedWriter bw = new BufferedWriter(writer);
                ){
//            char[] c = new char[1024];
//            int len;
//            while((len = br.read(c)) != -1){
//                bw.write(c,0,len);
//            }
//            System.out.println("复制完成");



            // 新增方法 读取一行数据
//            String s = br.readLine(); // 读取一行数据
//            String s = br.readLine(); // 读取一行数据
//            String s = br.readLine(); // 读取一行数据 没数据了会返回null

//            bw.write(s);
//            bw.newLine();



            String line;
            while((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine(); // 写入换行符
            }



        }catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("3 案例");
        try(
                BufferedReader br = new BufferedReader(new FileReader("1/src/com/io/io6/test.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("1/src/com/io/io6/test2.txt"));
                ){
            List<String> data = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null){
                data.add(line);
            }

            Collections.sort(data); // 默认按照字符串首字母排序
            for (String s : data) {
                bw.write(s);
                bw.newLine();
            }
            System.out.println("排序完成");

        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("4 原始流 缓冲流的性能分析");
        // 分别使用原始的字节流，以及字节缓冲流复制一个很大的视频
        // 这里就不测试了 字节缓冲流 且用数组的方式最快


    }

}
