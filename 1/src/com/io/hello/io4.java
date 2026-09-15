package com.io.hello;

import com.io.io4.MyConnection;

import java.io.*;

public class io4 {
    public static void main(String[] args) {
        System.out.println("1 释放资源");
        // 原来的代码是在最后 释放资源 进行is.close();os.close();
        // 这样会有问题 如果中将代码有bug 就不会执行到最后的资源释放 这样系统资源就得不到释放

        System.out.println();
        System.out.println("2 释放资源方式1 try-catch-finally");
        // finally代码区的特点：无论try中的程序是正常执行了，还是出现异常，最后都一定会执行finally区，除非JVM终止
        // 作用：一般用于在程序执行完成后进行资源的释放操作（专业级做法）；


        try {
            System.out.println(10 / 0); // 即便程序出错 即便跳出方法  finally区的代码也会执行
            //System.exit(0); // 除非虚拟机挂了  finally区的代码才不会执行
            return;

        } catch (Exception e) {
            System.out.println("出现异常了");
        } finally {
            System.out.println("释放资源");
        }

        System.out.println(chu(10,0));  // finally区的return会覆盖 try和catch部分的return

        System.out.println();
        InputStream iis = null;
        OutputStream oos = null;
        try {
            iis = new FileInputStream("1/src/com/io/io4/test1.txt");
            oos = new FileOutputStream("1/src/com/io/io4/test1_copy.txt");

            byte[] bf = new byte[1024]; // 1kB
            int ln;
            while ((ln = iis.read(bf)) != -1) {
                oos.write(bf,0,ln);
            }

            System.out.println("文件复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (iis != null) iis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("3 释放资源方式2 try-with-resources");
        // jdk7 提供了 try-with-resources 语句    比try-catch-finally更简洁
        // 资源的声明必须在括号内，且用分号隔开，该资源使用完毕后后，会自动调用其close方法，完成对资源的释放
        // 资源都会实现 AutoCloseable 接口，都会有一个close方法，；并且资源放到这里用完之后会自动关闭


        try (  // （）中只能放置 资源 否则报错
                InputStream  is = new FileInputStream("1/src/com/io/io4/test1.txt");
                OutputStream  os = new FileOutputStream("1/src/com/io/io4/test1_copy.txt");

                MyConnection conn = new MyConnection(); // 演示资源自动释放
                ){

            byte[] bf = new byte[1024]; // 1kB
            int ln;
            while ((ln = is.read(bf)) != -1) {
                os.write(bf,0,ln);
            }

            System.out.println(conn);
            System.out.println("文件复制完成");

        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    public static int chu(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println("出现异常了");
            return -1;
        }
        finally {
            // 千万不要在这里写return
            return 111;
        }
    }
}
