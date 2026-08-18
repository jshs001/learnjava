package com.itheima1.gaoji0;

public class Student {
    public static String name;
    public int age;

    public static void printHelloWorld() {
        System.out.println("Hello World");
    }

    public void printChengNianIf() {
//        System.out.println("年龄大于18岁是成年");
        System.out.println(age > 18 ? "成年" : "未成年");
    }
}
