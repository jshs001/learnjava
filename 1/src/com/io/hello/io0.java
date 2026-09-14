package com.io.hello;

import java.io.File;
import java.util.Arrays;

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
//        File 1.阿斯蒂芬 = new File("..\\io0\\ab.txt"); // 路径分隔符要用\\ 或File.separator
//        File 1.阿斯蒂芬 = new File(".."+File.separator+"io0"+File.separator+"ab.txt");
        File f1 = new File("1/src/com/io/io0/ab.txt");
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
        File f4 = new File("1/src/com/io/io0/ab1.txt");
        try {
            System.out.println(f4.createNewFile()); // 创建文件 如果文件存在则返回false
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(f4.delete()); // 删除文件 如果文件不存在则返回false

        File f5 = new File("1/src/com/io/io0/test");
        System.out.println(f5.mkdir()); // 创建一级文件夹
        System.out.println(f5.delete()); // 删除文件和空文件夹 删除后不进入回收站 直接永久删除

        File f6 = new File("1/src/com/io/io0/test/test1");
        System.out.println(f6.mkdirs()); // 创建多级文件夹
        System.out.println(f6.delete()); // 只能删除一级文件夹
        System.out.println(f5.delete());

        System.out.println();
        System.out.println("4 File类遍历文件夹");
        File f7 = new File("1/src/com/io/io0");
        String[] names = f7.list();  // 获取当前目录下所有一级文件名称到一个字符串数组中返回
        for (String name : names) {
            System.out.println(name);
        }

        File[] files = f7.listFiles();  // 获取当前目录下所有一级文件和文件夹的File对象到一个File数组中返回
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        // 注意：list()和listFiles()方法获取当前目录下所有的一级文件名称或一级文件对象
        System.out.println();
        // listFiles方法的注意事项
        // 1 当主调是文件，或者路径不存在时，返回null
        File f8 = new File("1/src/com/io/io01");
        System.out.println(f8.listFiles()); // 返回null

        // 2 当主调是空文件夹时，返回一个长度为0的数组
        File f9 = new File("1/src/com/io/io0/kt");
        System.out.println(Arrays.toString(f9.listFiles())); // 返回一个长度为0的数组

        // 3 当主调是一个有内容的文件夹时，将里面所有的一级文件和文件夹的路径放到file数组中返回
        File f10 = new File("1/src/com/io/io0");
        File[] files1 = f10.listFiles();
        for (File file : files1) {
            System.out.println(file);
        }

        // 4 当主调是一个文件夹，里面含有隐藏文件时，将里面苏哟文件和文件夹的路径放到File数组中返回，包含隐藏文件。
        // 5 当主调是一个文件夹，但是没有权限访问该文件夹时，返回null。

        System.out.println();
        System.out.println("5 案例");

        File dir = new File("1/src/com/io/io0/kt1");

        File[] files2 = dir.listFiles();
        for (File file : files2) {
            String name = file.getName();
            String index = name.substring(0,name.indexOf("."));
            String lastName = name.substring(name.indexOf("."));
            String newName = (Integer.valueOf(index) + 1) + lastName;

            file.renameTo(new File(dir, newName));
        }



    }
}
































