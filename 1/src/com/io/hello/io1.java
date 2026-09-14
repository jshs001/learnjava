package com.io.hello;

import com.io.io1.BottleExchange;

import java.io.File;
import java.io.IOException;



public class io1 {
    public static void main(String[] args) throws IOException {
        System.out.println("1 方法递归");
        // 概念：递归是一种算法，在程序设计语言中广泛应用
        // 从形式上说：方法调用自身的形式称为方法递归。

        // 递归的形式：
        // 直接递归： 方法自己调用自己
        // 间接递归： 方法调用其他方法，其他方法又回调方法自己

        // test1(); // 直接方法递归 死循环 报错 StackOverflowError 栈内存溢出， 无限的把方法栈中加载方法
        // test2(); // 间接方法递归

        System.out.println();
        System.out.println("2 方法递归案例");
        // 计算n的阶乘
        System.out.println(f(5));

        // 递归算法三要素
        // 1 递归公式：f(n) = n * f(n - 1)
        // 2 递归的终结点：f(1) = 1
        // 3 递归的方向必须走向终结点：f(n) -> f(n - 1) -> ...-> f(1)

        // 计算fn + f(n - 1)
        System.out.println(f1(5));

        // 猴子吃桃子问题
        System.out.println(peach(1));
        System.out.println(peach(2));
        System.out.println(peach(3));

        System.out.println();
        System.out.println("3 文件搜索案例");
        fileSearch(new File("1/src/com/io/io0"), "qq");

        System.out.println();
        System.out.println("4 删除非空文件夹案例");
        File f = new File("1/src/com/io/io0/kt3");
        f.mkdir(); // 创建一级文件夹
        File f1 = new File("1/src/com/io/io0/kt3/ab1.txt");
        f1.createNewFile(); // 创建文件 如果文件存在则返回false
        File f2 = new File("1/src/com/io/io0/kt3/ab2.txt");
        f2.createNewFile(); // 创建文件 如果文件存在则返回false
        File f3 = new File("1/src/com/io/io0/kt3/test");
        f3.mkdir(); // 创建二级文件夹
        File f4 = new File("1/src/com/io/io0/kt3/test/test1.txt");
        f4.createNewFile(); // 创建文件 如果文件存在则返回false

        deleteDir(f);

        System.out.println();
        System.out.println("5 啤酒案例");
        // 2元一瓶 4个盖子可以换一瓶 2个空瓶可以换一瓶 请问10元可以喝多少瓶
        BottleExchange.Suan();
        BottleExchange.Suan(10);



    }


    // 直接方法递归
    public static void test1() {
        System.out.println("------test1-----------");
        test1();// 直接方法递归
    }

    // 间接方法递归
    public static void test2() {
        System.out.println("------test2-----------");
        test3();
    }
    public static void test3() {
        System.out.println("------test3-----------");
        test2();
    }

    // 计算阶乘案例
    public static int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * f(n - 1);
        }
    }
    // 计算fn + f(n - 1)
    public static int f1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + f1(n - 1);
        }
    }

    // 猴子吃桃子的问题
    public static int peach(int day) {
        if (day == 10) {
            return 1;
        } else {
            return 2 * (peach(day + 1) + 1);
        }
    }

    // 文件搜做
    public static void fileSearch(File dir, String fileName) {
        if (dir == null || !dir.exists() || dir.isFile()) {
            return;
        }

        File[] files = dir.listFiles();
        if(files != null && files.length > 0){
            for (File f : files) {
                if (f.isFile()) {
                    if (f.getName().contains(fileName)) {
                        System.out.println("找到了：" + f.getAbsolutePath());
                    }
                } else {
                    fileSearch(f, fileName);
                }
            }
        }
    }

    // 删除非空文件夹
    public static void deleteDir(File dir) {
        if (dir == null || !dir.exists() ) {
            return;
        }
        if(dir.isFile()) {
            dir.delete();
            return;
        }

        File[] files = dir.listFiles();
        if (files == null){
            return;
        }
        if ( files.length == 0) {
            dir.delete();
            return;
        }



        for (File f : files) {
            if (f.isFile()) {
                f.delete();
            } else {
                deleteDir(f);
            }
        }
        dir.delete();

    }
}
