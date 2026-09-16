package com.io.hello;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class io5 {
    public static void main(String[] args) {
        System.out.println("1 字符流");
        // 字节流适合复制文件等，不适合读写文件，字符流适合读写文本文件内容

        System.out.println();
        System.out.println("2 FIleReader 文件字符输入流");

        try (
                Reader fr = new FileReader("1/src/com/io/io5/test.txt")) {

            // 每次读取一个字符 性能差
//            int c;
//            while ((c = fr.read()) != -1) {
//                System.out.print((char) c);
//            }

            // 每次读取多个字符
            char[] cbuf = new char[3];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                System.out.print(new String(cbuf, 0, len));
            }


        } catch ( Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("3 FileWriter 文件字符输出流");

        try (
                Writer fw = new FileWriter("1/src/com/io/io5/test1.txt");  // 覆盖
                // Writer fw = new FileWriter("1/src/com/io/io5/test1.txt", true);  // 追加
        ) {
            fw.write("hello world");
            fw.write('c');
            fw.write(97);
            fw.write("中");
            fw.write("嗡嗡嗡嗡嗡嗡");
            fw.write("哇哇哇哇",0,3);
            fw.write("\r\n");

            // 写字符数组出去
            char[] cbuf = {'黑','白','蓝'};
            fw.write(cbuf);
            fw.write(cbuf,0,2);


        }catch (Exception e) {
            e.printStackTrace();
        }

        // 字符输出流写出数据后，必须刷新流，或者关闭流，写出去的数据才能生效
        // 如果不用try-with-resources或 try-catch-finally关闭流，则必须手动刷新流或手动关闭流，否则可能会出现数据写不到磁盘的bug
        // 例如：fw.flush(); 刷新后 还可以使用流 进行fw.write()
        // 例如：fw.close(); 关闭后就不能再使用流了  关闭流包含了刷新动作






















    }
}
