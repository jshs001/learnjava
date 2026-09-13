package com.io.hello;

import java.io.File;

public class io0 {
    public static void main(String[] args) {
        System.out.println("1 File IO流概述");
        // 数据的存储方案： 1 变量    2 数组    3 对象    4 集合  等都是存储在内存的 断电或者程序中断 数据会丢失
        // 数据的持久化存储： 1 文件    2 数据库等  实际是存在在硬盘中的 断电或者程序中断 数据不会丢失
        // File是java.io包中的一个类，File类对象用于代表当前操作系统的文件（文件、文件夹），提供了很多操作文件和文件夹的方法 但是不能读写文件的内容
        // IO流用于读写数据的（可以读写文件，或网络中的数据...）

        // File代表文件 IO流读写数据

        System.out.println();
        System.out.println("2 File类的创建");
        // File:文件和目录名的抽象表示
        // 1 创建file对象
//        File f1 = new File("..\\io0\\ab.txt"); // 路径分隔符要用\\ 或File.separator
//        File f1 = new File(".."+File.separator+"io0"+File.separator+"ab.txt");
        File f1 = new File("1/src/com/io/hello/io0/ab.txt");
        System.out.println(f1.getName());
        System.out.println(f1.length());

        File f2 = new File("..\\io0");
        System.out.println(f2.getName());
        System.out.println(f2.length());  // 这里只会取到文件夹本身的大小 不会取到文件夹中包含的所有文件和文件夹的大小

        File f3 = new File("..\\io0\\ab1.txt"); // 可以指向一个不存在的文件
        System.out.println(f3.getName());
        System.out.println(f3.length());
        System.out.println(f3.exists());
        // 注意路径有绝对路径和相对路径
        // 注意：java的当前目录是项目的根目录  而不是深层的包目录；linux的当前目录是cd的目录。

        // File对象既可以代表文件 也可以代表文件夹
        // File封装的对象仅仅是一个路径名，这个路径可以存在也可以不存在

        System.out.println();
        System.out.println("3 File类的常用方法");
        // 获取文件和目录信息
        System.out.println(f1.exists()); // 判断文件是否存在 如果是使用相对路径 一定相对项目的根目录的路径
        System.out.println("当前程序运行的真实起点位置是: " + new File(".").getAbsolutePath()); // 查看当前程序运行的真实起点位置
        System.out.println(f1.isFile()); // 判断是否是文件
        System.out.println(f1.isDirectory()); // 判断是否是文件夹
        System.out.println(f1.getName()); // 获取文件名
        System.out.println(f1.length()); // 获取文件长度
        System.out.println(f1.lastModified()); // 获取文件最后修改时间
        System.out.println(f1.canRead()); // 判断文件是否可读
        System.out.println(f1.canWrite()); // 判断文件是否可写
        System.out.println(f1.canExecute()); // 判断文件是否可执行
        System.out.println(f1.isHidden()); // 判断文件是否隐藏
        System.out.println(f1.getAbsolutePath()); // 获取文件的绝对路径
        System.out.println(f1.getAbsoluteFile()); // 获取文件的绝对路径的File对象
        System.out.println(f1.getPath()); // 获取文件的路径 就是相对路径

        // 创建和删除文件

    }
}
