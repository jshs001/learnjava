package com.itheima1.gaoji2;

public class Teacher extends People{
    public String name = "teacher name";

    @Override
    public void run(){
        System.out.println("teacher run");
    }

    public void teach(){
        System.out.println("teacher teach");
    }
}
