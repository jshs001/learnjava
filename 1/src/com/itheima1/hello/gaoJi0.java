package com.itheima1.hello;

import com.itheima1.gaoji0.*;

public class gaoJi0 {
    public static void main(String[] args) {

        // static：静态 ,可以修饰成员变量和成员方法

        System.out.println(" 1 static 修饰成员变量");
        // 成员变量用static修饰 叫做类变量，在计算机中只有一份 会被类的全部对象共享；
        // 不用 static 修饰的成员变量 叫做实例变量(成员变量) ，每创建一个对象 就会有一份，互不干扰

        // 类变量的用法
        Student.name = "张三"; // 类名.类变量方法访问（推荐）
        Student s1 = new Student();
        s1.name = "丽丝"; // 对象.类变量（不推荐）

        Student s2 = new Student();
        s2.name = "王五";

        System.out.println(s1.name); // 王五

        // 实例变量的用法
        s1.age = 18;
        s2.age = 20;

        System.out.println(s1.age); // 18

        // 使用场景 ： 如果某个数据只需要一份，且希望能够被共享（访问。修改），则该数据可以定义成类变量来记住。
        // 案例：用户类在新建用户时候 记住自己创建了多少个用户。
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        System.out.println(User.number);

        System.out.println();
        System.out.println();
        System.out.println("2 static 修饰成员方法");
        // 类方法：用 static 修饰的方法 叫做类方法 属于类   访问方式：类名.方法名（推荐） 对象名.方法名（不推荐）
        // 实例方法：不用 static 修饰的方法 叫做实例方法 属于对象   访问方式：对象名.方法名

        // 类方法
        Student.printHelloWorld();
        s1.printHelloWorld();

        // 实例方法
        s1.printChengNianIf();
        s2.printChengNianIf();

        // 补充main方法 就是类方法。main方法为啥能直接跑起来，是因为java虚拟机会调用类名.main方法执行。
        // 如何给main方法传参。cmd命令行 java 类名 参数1 参数2 参数3...即可      （args就是参数的数组。）

        // 类方法应用场景：最常见的是工具类，比如Math类、Arrays类、Collections类等等
        // 工具类中的方法都是一些类方法，每个方法都是用来完成一个功能的，工具类是给开发人员共同使用的。
        // 案例：见MyUtil类 和使用了 MyUtil类方法的 LoginDemo类 和 RegisterDemo类 。这样大大简化了代码和开发效率。

        // 为什么工具类中的方法要用类方法而不是实例方法：实例方法需要创建对象来调用，此时对象只是为了调用方法，对象占内存，这样浪费内存。
        // 此时工具类就没有必要创建对象 可以把构造器私有化 见MyUtil类代码
        // 如开发文档中 Math类 就没有构造器 方法摘要中的方法 都是带着static的

        System.out.println();
        System.out.println("3 static 注意事项");
        // 见student1类
        // 1 类方法中可直接访问类的成员，但不能直接访问实例成员
        // 2 实例方法中可直接访问类的成员，也可直接访问实例成员
        // 3 实例方法中可出现this关键字,类方法不能出现this关键字

        System.out.println();
        System.out.println("4 static 代码块");
        // 代码块：是类的5大成分之一（成员变量 构造器 方法 代码块  内部类 ）
        // 代码块分为静态代码块 和 实例代码块
        // 静态代码块：格式 static {} ； 在类加载时自动执行，由于类只会加载一次，所以静态代码块也只执行一次； 作用是完成类的初始化，比如类变量的初始化赋值。
        // 见student2

        System.out.println(Student2.number);
        System.out.println(Student2.number);
        System.out.println(Student2.number); // 此时调用三次静态成员 但是静态代码块只执行一次
        System.out.println(Student2.schoolname); // 访问静态成员变量 这个变量已赋值

        // 应用了静态代码块的地方 如Scoket类的代码

        // 实例代码块： 格式：{  } 特点：每次创建对象时，执行实例代码块，并在构造器前执行。 作用：和构造器一样，都是用来完成对象的初始化的 例如：对实例变量进行初始化赋值
        Student2 s21 = new Student2();
        Student2 s22 = new Student2("张三");


        System.out.println();
        System.out.println("5 static 单例设计模式");
        // 什么是设计模式 ？ 设计模式是解决一类问题的最佳实践。一个问题通常有n种解法，其中肯定有一种解法是最优解，这个最优解法被人总结出来了，称之为设计模式。
        // 设计模式有20多种，对应20多种软件开发中会遇到的问题

        // 设计模式怎么学？ 主要学什么？ 1 学解决什么问题 2 学怎么写

        // 单例设计模式 ： 确保一个类只有一个对象。
        // 写法： 把类的构造器私有化； 定义一个类变量记住类的一个对象 ；定义一个类方法返回对象
        // 见A类

        // A a1 = new A();
        A a1 = A.getObject();
        A a2 = A.getObject();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1 == a2);

        // 单例模式的应用场景和好处 如Runtime类（java程序的运行环境 就需要一个就行） 或者说windows的任务管理器也是一个就行

        // 单例的设计模式的实现方式有很多
        // 1 饿汉式 ： 拿到对象时，对象早就创建好了。  A类就是饿汉式
        // 2 懒汉式 ： 拿到对象时，对象才创建。  B类就是懒汉式
        // 3... 等

        // 懒汉式 单例写法 ：把类的构造器私有化； 定义一个类变量用于存储对象 ；提供一个类方法，保证返回的是同一个对象。
        B b1 = B.getObject();
        B b2 = B.getObject();
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);

        // 如果这个工具需要经常用 用饿汉式 如果偶尔用 用懒汉式
    }
}
