package com.io.hello;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class io8 {
    public static void main(String[] args) {
        System.out.println("1 打印流");
        // PrintStream PrintWriter:字节打印流 字符打印流
        // 作用：可以实现更方便、更高效的打印数据出去，能实现打印啥出去就是啥出去

        // 打印流包装了缓冲流 所以性能会很好


        try (
//                PrintStream ps = new PrintStream("1/src/com/io/io8/test.txt", Charset.forName("GBK")); // 可以指定输出的字符集
//                PrintStream ps = new PrintStream("1/src/com/io/io8/test.txt");

                //PrintWriter ps = new PrintWriter(new FileOutputStream("1/src/com/io/io8/test.txt"), true);  // 追加需要包装低级流
                PrintWriter ps = new PrintWriter("1/src/com/io/io8/test.txt");
                ){
            ps.println("hello");
            ps.println(97); // 输出97
            ps.println(true);
            ps.println(123.45);
            ps.println('a');
            ps.println("你好");

            ps.write(97); // 输出字符'a'
            ps.write("时"); // 输出字符'a'

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("2 输出语句的重定向");
        // 可以把输出语句System.out.println(); 打印的内容 重定向到文件

        System.out.println("老骥伏枥");
        System.out.println("志在千里");
        try(
                PrintStream ps = new PrintStream("1/src/com/io/io8/test1.txt")
                )
        {
            System.setOut(ps);  // 把系统默认的打印流对象改成自己设置的打印流
            System.out.println("烈士暮年");
            System.out.println("壮心不已");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
