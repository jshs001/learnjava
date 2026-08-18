package com.itheima1.gaoji0;

public class B {
    // 2 定义一个类变量 用于存储这个类的一个对象
    private static B b;

    // 1 私有化构造器
    private B() {
    }

    // 3 定义一个类方法 这个方法保证第一个次调用时才创建一个对象，后面调用时都会返回同一个对象
    public static B getObject() {
        if (b == null){
            b = new B();
        }
        return b;
    }
}
