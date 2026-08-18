package com.itheima1.gaoji0;

public class A {
    // 2 定义一个类变量记住类的一个对象
    private static A a = new A();

    // 1 私有化类的实例对象
    private A (){};

    // 3 定义一个类方法返回类的对象
    public static A getObject(){
        return a;
    }
}
