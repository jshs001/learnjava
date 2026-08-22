package com.itheima1.hello;

public class gaoji3 {
    // 常量 public static final修饰的成员变量 就是常量，常量建议名称全部大写 多个单词下划线连接
    public static final String SCHOOL_NAME = "黑马"; // 静态成员变量 此时final修饰后需要赋值

    private final String name = "张三"; // 实例成员变量

    public static void main(String[] args) {
        System.out.println("1 final关键字");
        // final概念：是最终的意思，可以修饰类、方法、常量
        // 修饰类：该类被称为最终类，不能被继承
        // 修饰方法：该方法被称为最终方法，不能被重写
        // 修饰常量：该常量只能被赋值一次。

        // 3 修饰变量
        /*
            一 局部变量
            二 成员变量
               1 静态成员变量
               2 实例成员变量
         */
        final int a;
        a = 10;
        // a = 20; // final局部变量只能被赋值一次

        final double r = 3.14;
        // r = 3.14159; // final局部变量只能被赋值一次

        // SCHOOL_NAME = "白马"; // final静态成员变量只能被赋值一次

        gaoji3 gj = new gaoji3();
        // gj.name = "张三"; // 实例成员变量不可以被重新赋值


        // final修饰变量的注意：
        // final修饰基本类型的变量，变量值不能被重新赋值
        // final修饰引用类型的变量，变量地址不能被重新赋值，但是地址所指向对象的内容可以被修改
        final int[] arr = new int[10];
        arr[0] = 10;
        // arr = null; // final引用类型变量，变量地址不能被重新赋值


        System.out.println();
        System.out.println("2 常量 public static final修饰的成员变量 就是常量");
        // 概念：使用了public static final修饰的成员变量，称为常量
        // 作用：通常用于记录系统的配置信息。
        // 常量命名规则：全部大写，多个单词用下划线连接

        // 好处：可读性好 可维护性好 （方便做集中配置）
        // 程序编译后常量会被“宏替换”：出现常量的地方直接用常量的值（字面量）替换，性能好。
        System.out.println(SCHOOL_NAME); // 这里编译后 把class文件反编译出来 看源码就看见这里就是 "黑马"





    }

    public static void buy(final double price) {
        // price = 10; // final局部变量不能被重新赋值
        System.out.println("buy " + price);
    }

}
// 1 final修饰类
final class A2 {}
//class B extends A2 {}

// 2 修饰方法
class C {
    final void show() {
        System.out.println("show c");
    }
}
class D extends C {
    public void testb1() {
    }
//    @Override
//    void show() {
//        System.out.println("show d");
//    }
}