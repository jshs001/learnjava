package com.itheima1.gaoji4;
// 抽象类
public abstract class A {
    public static String schoolName;
    private String name;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    // 抽象方法
    public abstract void run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
