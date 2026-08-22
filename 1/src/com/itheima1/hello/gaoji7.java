package com.itheima1.hello;

import com.itheima1.gaoji7.A;
import com.itheima1.gaoji7.B;
import com.itheima1.gaoji7.Constant;
import com.itheima1.gaoji7.Contant1;

public class gaoji7 {
    public static void main(String[] args) {
        System.out.println("1 枚举");
        // 概念：是一种特殊类。
        // 格式：修饰符 enum 枚举类名 {
        //      名称1,名称2,...
        //      其他成员...
        // }

        A a = A.X;
        System.out.println(a);
        // 可以到编译后的目录找到枚举定义的类文件 A.class 反编译这次不要用idea 用cmd命令行
        // cmd命令行输入：javap A.class
        // 可以看到枚举类的对象是用常量记录的

        // 特点：
        // 枚举类的第一行只能罗列一些名称，这些名称都是常量，并且每个常量记住的都是枚举类的一个对象。（cmd javap 命令反编译可见）
        // 枚举的构造器都是私有的（写不写都只能是私有的），因此，枚举类对外不能创建对象。 （idea反编译可见）
        // 枚举类都是最终类，不可以被继承。
        // 枚举类中，从第二行开始，可以定义类的其他各种成员。
        // 编译器为枚举类新增了几个方法，并且枚举类都是继承：java.lang.Enum类的，从enum类也会继承到一些方法。

        // A a = new A(); // 不能创建对象
        A a1 = A.Y;
        System.out.println(a1);
        A [] as = A.values(); // 获取所有枚举对象
        System.out.println(as);
        A a2 = A.valueOf("Z"); // 获取枚举对象
        System.out.println(a2.name()); // 获取枚举对象的名称
        System.out.println(a2.ordinal()); // 获取枚举对象的序号 索引

        System.out.println();
        System.out.println("抽象枚举类");
        B z = B.Z;
        z.go(); // 调用枚举对象的方法

        // 枚举还能快速实现一个单例模式
        // 见C类

        System.out.println();
        System.out.println("枚举应用场景");
        // 非常适合用来表示一组信息，然后作为参数进行传输，比如：星期、季节、方向、颜色、性别、操作、状态等等。以便做信息分类和标志。
        System.out.println("信息分类无意义：");
        check(0); // 男 这种写法不好，因为0和1是数字，没有意义，应该使用枚举来表示性别
        System.out.println("信息分类有意义(用常量表示)：");
        check1(Constant.boy); // 男
        System.out.println("信息分类有意义 可读性好且严谨(用枚举表示)：");
        check1(Contant1.Boy); // 男

        // 注意： 其实实际开发有的场景有时候还是用的常量，常量的好处是简单 且可附有各种基本类型和包装类 项目中有时候需要具体的值做处理。
    }

    public static void check(int sex) {
        switch (sex) {
            case 0:
                System.out.println("男");
                break;
            case 1:
                System.out.println("女");
                break;
        }
    }
    public static void check1(int sex) {
        switch (sex) {
            case Constant.boy:
                System.out.println("男");
                break;
            case Constant.girl:
                System.out.println("女");
                break;
        }
    }
    public static void check1(Contant1 sex) {
        switch (sex) {
            case Boy: // 这里不需要带前缀Constant1.boy; switch天生优化了枚举
                System.out.println("男");
                break;
            case Girl:
                System.out.println("女");
                break;
        }
    }
}
