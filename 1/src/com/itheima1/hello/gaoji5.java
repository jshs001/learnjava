package com.itheima1.hello;

import com.itheima1.gaoji5.ClassManager;
import com.itheima1.gaoji5.D;

public class gaoji5 {
    public static void main(String[] args) {
        System.out.println("1 接口");
        // 概念： interface关键字修饰；接口中的成员变量就是常量，成员方法就是抽象方法。

        // 接口不能创建对象，不能有构造方法、非抽象方法和代码块。是用来继承的，实现接口的类称实现类。

        // 一个类可以实现多个接口（理解为可以有多个干爹），实现类必须重写完全部接口的全部抽象方法，否则实现类需要定义成抽象类。

        D d = new D();
        d.test();
        d.testb1();
        d.testb2();
        d.testc1();
        d.testc2();

        // 接口的好处：
        // 弥补了java单继承的不足，一个类同时可以实现多个接口
        // 让程序员可以面向接口编程，这样程序员就可以灵活方便的切换各种业务实现
        Driver a1 = new A51();
        Singer a2 = new A51();
        A51 a3 = new A51();
        a3.drive();
        a3.sing();

        // 面向接口编程 跟多态一样
        Driver b1 = new B51(); // 这里是Driver类型: new B1() 随时可以切换为其他实现类 如new A1()
        b1.drive();

        System.out.println("2 面向接口编程 综合案例");
        ClassManager classManager = new ClassManager();
        classManager.printInfo();
        classManager.printAverageScore();


    }
}

// 弥补了java单继承的不足，一个类同时可以实现多个接口

class A51 extends Student51 implements Driver, Singer {
    @Override
    public void drive() {
        System.out.println("A1 drive");
    }
    @Override
    public void sing() {
        System.out.println("A1 sing");
    }
};

class Student51 {}

interface Driver {
    void drive();
}

interface Singer {
    void sing();
}


// 面向接口编程
class B51 implements Driver{
    @Override
    public void drive() {
        System.out.println("B1 drive");
    }
}