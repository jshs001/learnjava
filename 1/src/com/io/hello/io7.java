package com.io.hello;

import java.io.*;

public class io7 {
    public static void main(String[] args) {
        // 转换流
        System.out.println("1 字符流读取文本文件 乱码问题");
        // 不同编码读取出现乱码的问题：
        // 如果代码编码和被读取的文本文件的编码是一致的，使用字符流读取文本文件时不会出现乱码
        // 如果代码编码和被读取的文本文件的编码不一致，使用字符流读取文本文件时会出现乱码

        try (
                // 不乱码 因为代码和文件的编码一致
//                BufferedReader br = new BufferedReader(new FileReader("1/src/com/io/io7/test.txt"));

                // 乱码 因为代码和文件的编码不一致
                BufferedReader br = new BufferedReader(new FileReader("1/src/com/io/io7/test1.txt"));
                ){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("2 转换流");
        // 解决不同编码时，字符流读取文本内容乱码的问题
        // 解决思路：先获取文件的原始字节流，再将其按真是的字符集编码转成字符输入流，这样字符输入流中的字符就不乱码了。
        try (
                InputStream is = new FileInputStream("1/src/com/io/io7/test1.txt");
                Reader isr = new InputStreamReader(is, "GBK");
                BufferedReader br = new BufferedReader(isr);
        ){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 字符输出转换流 能控制写出去的字符的编码
        try (
                OutputStream os = new FileOutputStream("1/src/com/io/io7/test2.txt");
                Writer osw = new OutputStreamWriter(os, "GBK");
                BufferedWriter bw = new BufferedWriter(osw);
        ){
            bw.write("我爱你");
            bw.newLine();
            bw.write("你和我");
        } catch (Exception e) {
            e.printStackTrace();
        }
















    }
}
