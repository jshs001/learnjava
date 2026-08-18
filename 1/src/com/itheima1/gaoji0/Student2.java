package com.itheima1.gaoji0;

public class Student2 {
    public static int number =80;
    public static String schoolname;
    // 静态代码块
    static {
        System.out.println("静态代码块执行了");
        schoolname = "黑马";
    }

    // 实例代码块
    {
        System.out.println("实例代码块执行了");
        System.out.println("有人创建了对象"+this);
    }

    public Student2() {
        System.out.println("无参构造方法执行了");
    }
    public Student2(String name){
        System.out.println("有参构造方法执行了"+name);
    }
}
