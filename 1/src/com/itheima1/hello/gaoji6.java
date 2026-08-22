package com.itheima1.hello;

import com.itheima1.gaoji6.Outer;
import com.itheima1.gaoji6.Outer1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gaoji6 {
    public static void main(String[] args) {
        System.out.println("1 内部类概念");
        // 概念：内部类是类中的五大成分之一（成员变量、构造器、方法、代码块、内部类），如果一个类定义在另一个类的内部，这个类就是内部类。
        // 场景：当一个类的内部，包含了一个完整的事物，且这个事物没有毕业单独设计时，就可以把这个事物设计成内部类。
        // 内部类有四种形式：成员内部类、静态内部类、局部内部类、匿名内部类

        System.out.println();
        System.out.println("2 成员内部类");
        // 概念：就是类中的一个普通成员，类似普通的成员变量和成员方法。
        Outer.Inner.schoolName = "Beijing University";
        System.out.println(Outer.Inner.schoolName);

        Outer.Inner in = new Outer().new Inner(); // 创建成员内部类对象 需要两次new
        in.setName("Zhang San");
        System.out.println(in.getName());

        System.out.println();
        Outer out = new Outer();
        out.setAge(42);
        Outer.name = "Zhang San";
        System.out.println(out.getAge());
        out.test();

        System.out.println();
        Outer.Inner in1 = out.new Inner();
        Outer.Inner.schoolName = "黑马";
        in1.setName("Zhang San son");
        System.out.println(in1.getName());
        in1.test();

        System.out.println();
        in1.setAge(22);
        in1.show();

        // 成员内部类的实例方法中，可以直接访问外部类的实例成员、静态变量
        // 外部类对象格式：外部类名.this.成员变量名
        // 外部类静态变量格式：外部类名.静态成员变量名
        // 内部类实例变量格式：this.成员变量名
        // 内部类静态变量格式：内部类名.静态成员变量名

        // 创建内部类对象 需要先创建外部类对象

        System.out.println();
        System.out.println("3 静态内部类");
        // 概念：有static修饰的内部类，称为静态内部类。属于外部类自己持有。

        // 创建静态内部类对象
        Outer1.Inner1 in2 = new Outer1.Inner1();
        in2.setName("Zhang San");
        System.out.println(in2.getName());

        // 静态内部类访问外部类特点：可以直接访问外部类的静态成员，不可以直接访问外部类的实例成员。

        System.out.println();
        System.out.println("4 局部内部类");
        // 概念：定义在外部类的方法中、代码块中、构造器等执行体中。
        // 这属于鸡肋语法，看看就好。
        // 见Outer2

        System.out.println();
        System.out.println("5 匿名内部类");
        // 概念：就是一种特殊的局部内部类；所谓匿名是指程序员不需要为这个类声明名字。
        // 写法：new 类或接口（参数）{ 类体 一般是方法重写 }
        // 特点：匿名内部类本质就是一个子类，并会立即创建出一个子类对象。、
        // 作用：用于更方便的创建一个子类对象。
        // 场景：通常作为一个参数传递给方法。

        // 以前我们创建子类对象如下：
        Animal6 a = new Cat6();
        a.cry();

        // 在开发中我们只需要创建一个子类对象，此时单独定义一个子类出来会比较麻烦。
        System.out.println();
        Animal6 a1 = new Animal6() { // 此时会做两件事 1 把这个匿名内部类编译成一个子类 2 创建这个子类对象
            // 打开编译后的目录 会看多一个带$的类文件，这个类文件反编译能看见匿名内部类定义写法

            @Override // 子类需要重写父类的抽象方法
            public void cry() {
                System.out.println("狗 汪汪叫");
            }
        };
        a1.cry();

        // 常见应用场景：
        System.out.println();
        System.out.println("6 匿名内部类常见应用场景");

        // 匿名内部类原始写法
        Swimming s = new Swimming() {
            @Override
            public void swim() {
                System.out.println("原始：狗 游泳飞快");
            }
        };
        go(s);

        // 简化
        go(new Swimming() {
            @Override
            public void swim() {
                System.out.println("简化1： 狗 游泳飞快");
            }
        });

        System.out.println();
        System.out.println("7 匿名内部类在开发中的真实使用场景");
        // GUI编程 （这是只是演示 真实GUI基本不用java代码实现）
        JFrame win = new JFrame("登录窗口");
        JPanel panel = new JPanel();
        win.add(panel);

        JButton btn = new JButton("登录");
        panel.add(btn);

        // 给按钮绑定单击事件监听器
        // 开发中实际是我们调用的接口需要用到匿名内部类实现。而接口的实现类只需要重写一个方法，用匿名内部类实现能极大的简化代码。
        // 匿名内部类的最终核心目的是为了简化代码
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(win, "登录一下");
//            }
//        });
        // 简化方法1
        btn.addActionListener(e -> JOptionPane.showMessageDialog(win, "登录一下"));





        win.setSize(400, 400);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setVisible(true);


    }

    // 设计一个方法，可以接收Swimming接口的一切实现类对象进来参加游泳比赛
    public static void go(Swimming s) {
        System.out.println();
        System.out.println("开始游泳比赛");
        s.swim();
    }

}

class Cat6 extends Animal6 {

    @Override
    public void cry() {
        System.out.println("猫 喵喵叫");
    }
}

abstract class Animal6 {
    public abstract void cry();
}

// 匿名内部类常见应用场景
interface Swimming {
    void swim();
}































