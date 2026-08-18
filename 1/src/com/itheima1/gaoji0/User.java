package com.itheima1.gaoji0;

public class User {
    public static int number;

    public User(){
//        User.number++;
        number++; // 同一个类中 访问自己的类变量 才可以这样写 否则必须通过类似 类名.类变量的方式访问
    }
}
