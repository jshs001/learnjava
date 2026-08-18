package com.itheima1.gaoji0;

public class Student1 {
    public static String schoolName;
    public String score;


    public static void printHelloWorld() {
        // 1 类方法中可直接访问类的成员，但不能直接访问实例成员
        schoolName = "黑马程序员";
        printHelloWorld1();

//        System.out.println(this);
//        System.out.println(score);
//        study();
    }

    public static void printHelloWorld1() {

    }

    public void study() {

        // 2 实例方法中可直接访问类的成员，也可直接访问实例成员
        schoolName = "黑马程序员";
        printHelloWorld1();

        System.out.println(score);
        study();

        // 3 实例方法中可出现this关键字,类方法不能出现this关键字
        this.schoolName = "黑马程序员";
    }
    public void sleep() {
    }
}
