package com.itheima1.gaoji2;

public class Student extends People{
    public String name = "student name";

    @Override
    public void run(){
        System.out.println("student run");
    }

    // 多态：子类独有方法
    public void study(){
        System.out.println("student study");
    }
}
