package com.itheima1.gaoji6;

public class Outer2 {
    public static void main(String[] args) {

    }
    // 局部内部类

    // 1 构造器
    public Outer2() {
        class A{}
        abstract class b {}
        interface C {}
    }

    // 2 成员方法
    public void test() {
        class A{}
        abstract class b {}
        interface C {}
    }

    //3 代码块
    {
        class A{}
        abstract class b {}
        interface C {}
    }
}
