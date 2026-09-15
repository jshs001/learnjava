package com.io.hello;

import java.io.*;

public class io3 {
    public static void main(String[] args) throws Exception {
        System.out.println("1 io流");
        // io流：input 输入流 负责把数据读到内存中去;output 输出流 负责写数据出去 写道磁盘或网络；

        // io流的分类：
        // 1 按照流的方向分为输入流和输出流
        // 2 按照流的最小单位分为字节流和字符流。 字节流适合操作所有类型的文件，字符流只适合操作文本文件。

        // IO流总统来看就有四大流与抽象类：
        // 字节流输入输出：InputStream OutputStream
        // 字符流输入输出：Reader Writer
        // 四大流都是以内存为基准把数据input到内存中 或output到磁盘或网络中，只是数据的单位不同，一个是字节单位 一个是字符单位；

        System.out.println();
        System.out.println("2 FileInputStream 文件字节输入流");

        // InputStream is = new FileInputStream(new File("1/src/com/io/io3/test.txt"));  // 多态
        InputStream is = new FileInputStream("1/src/com/io/io3/test.txt"); // 第二种构造器 推荐使用
        InputStream is1 = new FileInputStream("1/src/com/io/io3/test1.txt");



        // 每次读取一个字节
//        int b = is.read();  // 每次读取一个字节返回； 文件没内容了  返回-1
//        System.out.println((char)b);
//
//        int b1 = is.read();
//        System.out.println((char)b1);
//
//        int b2 = is.read();
//        System.out.println(b2);

        // 循环读取
        int b3;
        while ((b3 = is.read()) != -1) {
            System.out.print((char)b3);
        }
        System.out.println();
        // 读取数据的性能很差，因为每次只读取一个字节
        // 读取汉字输出会乱码！！ 无法避免！
        int b4;
        while ((b4 = is1.read()) != -1) {
            System.out.print((char)b4);
        }

        // 关闭流 流使用完毕之后一定要关闭；释放系统资源
        is.close();
        is1.close();




        System.out.println();
        System.out.println();
        // 每次读取多个字节到字节数组中去，返回读取的字节数量，读取完毕会返回-1
        InputStream is2 = new FileInputStream("1/src/com/io/io3/test2.txt");
        InputStream is3 = new FileInputStream("1/src/com/io/io3/test1.txt");

//        byte[] buffer = new byte[3];
//        int len = is2.read(buffer);
//        String rs = new String(buffer);
//        System.out.println(rs);
//        System.out.println("当次读取的字节数量：" + len);
//
//        int len2 = is2.read(buffer);
//        String rs2 = new String(buffer,0,len2);
//        System.out.println(rs2);
//        System.out.println("当次读取的字节数量：" + len2);
//
//        int len3 = is2.read(buffer);
//        System.out.println("当次读取的字节数量：" + len3);

        // 循环读取
        byte[] buffer1 = new byte[3];
        int len4;
        while ((len4 = is2.read(buffer1)) != -1) {
            String rs3 = new String(buffer1,0,len4);
            System.out.print(rs3);
        }
        // 性能得到明显提升，因为每次读取多个字节，减少了io次数
        // 这种方案也不能避免读取汉字输出乱码的问题
        is2.close();

        System.out.println();
        byte[] buffer2 = new byte[3];
        int len5;
        while ((len5 = is3.read(buffer2)) != -1) {
            String rs3 = new String(buffer2,0,len5);
            System.out.print(rs3);
        }
        is3.close();


        System.out.println();
        System.out.println();
        // 一次性读取全部字节
        // 方式1 字节定义一个字节数组与被读取的文件大小一致，然后使用该字节数组，一次性读完全部字节；
        InputStream is4 = new FileInputStream("1/src/com/io/io3/test1.txt");

        File f = new File("1/src/com/io/io3/test1.txt");
        long size = f.length();
        byte[] buffer3 = new byte[(int)size];
        int len7 = is4.read(buffer3);
        String rs4 = new String(buffer3,0,len7);
        System.out.println(rs4);
        System.out.println("当次读取的字节数量：" + len7);
        System.out.println("文件大小：" + size);
        is4.close();

        System.out.println();
        // 方式2 使用readAllBytes
        InputStream is5 = new FileInputStream("1/src/com/io/io3/test1.txt");
        System.out.println(new String(is5.readAllBytes()));
        is5.close();

        // 一次性读取全部字节可以避免乱码 但是如果文件过大，创建的字节数组也会过大，可能引起内存溢出；
        // 读写文本 更适合用字符流

        System.out.println();
        System.out.println("3 FileOutputStream 文件字节输出流");
        // 创建一个文件字节输出流与目标文件接通 目标文件可以不存在
        // OutputStream os = new FileOutputStream("1/src/com/io/io3/out.txt"); // 这是一个覆盖管道
        OutputStream os = new FileOutputStream("1/src/com/io/io3/out.txt",true); // 这是一个追加管道
        os.write(97); // 97是一个字节 代表a
        os.write('b'); // 'b'是一个字符 也是一个字节
        // os.write('中'); // 汉字是三个字节 默认只能写一个字节出去 所以会乱码

        byte[] bytes = "我爱你".getBytes(); // "我爱你" 转换为字节数组
        os.write(bytes);

        // 换行符
        os.write("\r\n".getBytes());
        os.write(bytes,0,9);

        os.close();

        System.out.println();
        System.out.println("4 文件复制案例");
        InputStream iis = new FileInputStream("1/src/com/io/io3/test1.txt");
        OutputStream oos = new FileOutputStream("1/src/com/io/io3/test1_copy.txt");

        byte[] bf = new byte[1024]; // 1kB
        int ln;
        while ((ln = iis.read(bf)) != -1) {
            oos.write(bf,0,ln);
        }
        iis.close();
        oos.close();
        System.out.println("文件复制完成");

        // 字节流非常适合做一切文件的复制操作
        // 任何文件的底层都是字节，字节流做复制，是一字不漏的转移完全部字节，只要复制后的文件格式一致就没问题；







    }
}
