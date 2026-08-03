package com.itheima.hello;

import java.util.Scanner;

public class rumen1 {
    public static void main(String[] args) {
        System.out.println("1 计算机是二进制方式存储的数据");
        // bit是1位 byte（字节）是8位
        // 计算机底层就是0和1 其他文字图片等都是通过编码实现转义的 如文本的ascii utf-8等 图片的像素点 声音的波形坐标等
        // 为了方便观查二进制 推出了八进制和十六进制 这三个进制在java代码中书写分别需要以0B或0b,0,0X或0x开头

        System.out.println("2 java数据类型 分为基本数据类型和引用数据类型");
        // 简单类型4 大类8种
        //     整型   byte 1字节 short 2字节 int（默认） 4字节 long 8字节
        //     浮点型 float 4字节 double（默认） 8字节
        //     字符型 char 2字节
        //     布尔型 boolean 1字节
        byte a = 127;
        short a1 = 13244;
        int a2 = 234243;
        long a3 = 23423423423l; //注意不加l会报错，随便写一个整型字面量默认是int类型的，23423423423已经超过了int的存储范围 所以报错 也可以写L

        float a4 = 3.14f;//随便写一个小数字面量 默认是double 如果希望小数是float 后面加f或F
        double a5 =54.54;

        char a6 = 'a';
        char a7 = '中';

        boolean a8 = true;
        boolean a9 = false;

//        扩展类型 字符串String 是引用类型
        String name = "张三";

        System.out.println("3 类型转换");
        System.out.println("3.1 自动类型转换：类型范围小的变量，可以直接赋值给类型变量大的变量");

        byte b = 12;
        int b1 = b;
        System.out.println(b);
        System.out.println(b1);

        // 自动类型转换顺序
        // byte -> short -> int -> long -> float -> double
        // char -> int -> long -> float -> double
        float b2 = a3;
        System.out.println(b2);

        System.out.println("3.2 表达式的自动类型转换：在表达式中小范围类型的变量，会自动转换成表达式中较大范围的类型，再参与运算");
        // byte、short、char-> int -> long -> float -> double
        // 表达式的最终结果是由表达式中最高类型决定的；且表达式中 byte、short、char是直接转换成int类型参与运算的。
        long a10 = a + a1 + a3;
        System.out.println(a10);

        int a11 = a + a1;
        System.out.println(a11);

        System.out.println("3.3 强制类型转换：大范围的变量赋值给小范围的变量");
        byte a12 = (byte) a2; //byte a12 = a2;会报错  按住alt + enter 选择强制类型转换
        // 有时候强制转换是业务的需要 但是会出现数据丢失的情况

        System.out.println("4 运算符");
        System.out.println("4.1 基本算数运算符");
        int m = 10;
        int n = 2;
        System.out.println(m + n);
        System.out.println(m - n);
        System.out.println(m / n);
        System.out.println(m * n);
        System.out.println(5 / 2); //表达式的结果是int类型 所以是2
        System.out.println(5.0 / 2);

        int n1 =3;
        System.out.println(1.0 * m / n1); //1.0 乘一下 让表达式的最大类型变成了double
        System.out.println(m % n);

        System.out.println("扩展+号的特殊作用 当+与字符串运算的时候是用作连接符的，其结果依然是一个字符串.");
        System.out.println("abc"+5);
        // 遇到+ 能算则算 不能算则连在一起 案例如下：
        int a13 = 5;
        System.out.println("abc" + a13);
        System.out.println(a13 + 5);
        System.out.println("abc" + a13 + 'a');
        System.out.println(a13 + a + "abc");

        System.out.println("4.2 自增自减运算符：只能作用变量 而不作用于字面量， 放在某个变量的前面或后面 对变量自身的值加或减1");
        int a14 = 10;
        a14++;
        System.out.println(a14);
        a14--;
        System.out.println(a14);
        ++a14;
        System.out.println(a14);
        --a14;
        System.out.println(a14);

        // 自增自减的使用注意事项
        // ++、--如果不是单独使用(如在表达式中、或者同时有其它操作)，放在变量前后会存在明显区别
        // 放在变量的前面，先对变量进行+1、-1，再拿变量的值进行运算。
        int a15 = 10;
        int rs = ++a15; //(先加再用)
        System.out.println(a15);
        System.out.println(rs);
        // 放在变量的后面，先拿变量的值进行运算，再对变量的值进行+1、-1
        int a16 = 10;
        int rs1 = a16++;//(先用再加)
        System.out.println(a16);
        System.out.println(rs1);

        System.out.println("4.3 赋值运算符：基本赋值运算符就是=；扩展赋值运算符 += -= *= /+ %=");
        int c = 10;
        double d = 2.0;
        c += d; //等价于 int c = (int)(c+d)
        System.out.println(c);
        // 扩展的赋值运算符 隐含了强制类型转换 a+=b 加后赋值 底层代码形式为 a = (a的类型)(a+b); 其他的-= *=... 效果一样

        System.out.println("4.4 关系运算符 > >= < <= == != 返回的是布尔值 ，注意判断相等一定是==");
        System.out.println(c>d);

        System.out.println("4.5 逻辑运算符 是把多个条件 放在一起 返回的是布尔值； & | ! ^ && ||");
        double c1 =9.9;
        int d1 = 16;
        boolean s = c1 <= 10 & d1 >= 10;  // 两条件 都true则true
        System.out.println(s);
        boolean s1 = c1 <= 10 | d1 <= 10;  // 两条件 一true则true
        System.out.println(s1);
        boolean s2 = !(c1 > 10); // 条件false则true true则false
        System.out.println(s2);
        boolean s3 = c1 <= 10 ^ d1 <= 10; // 两条件结果相反 则true 否则false

        int c2 = 10;
        int d2 = 20;
        System.out.println(c2 > 10 && ++d2 > 99); //  短路与 左边为false 则右边不执行 ,性能快 现实用的多
        System.out.println(d2);

        System.out.println(c2 > 10 & ++d2 > 99); //  与 不管成功失败都会执行完
        System.out.println(d2);

        System.out.println(c2 >= 10 || --d2 > 99); //  短路或 左边为true 则右边不执行 ,性能快 现实用的多
        System.out.println(d2);

        System.out.println(c2 >= 10 | --d2 > 99); //  或 不管成功失败都会执行完
        System.out.println(d2);

        System.out.println("4.6 三元运算符：条件变达式? 值1 : 值2;  true则值1 false值2");
        int max = c2 > d2 ? c2 : d2;
        System.out.println(max);

        System.out.println("5 案例获取用户输入");
        // 获取api文档 oracle官网 procude选择java 点击java download   下拉到自己对应的版本 版本下载的下面有个 documentation download;
        // 下载之后解压 用浏览器打开index文件即可查看 是英文的 网上应该有中文的
        // 搜索scanner 后即可查看相关接口文档

        Scanner sc = new Scanner(System.in); //键入Sc后就提示包了 双击即可完成import动作 不需要手写
        System.out.println("请输入您的age");
        int age = sc.nextInt(); //执行到这里 会开始等待用户输入一个参数 直到用户按下了回车键 就会拿到数据
        System.out.println("您的年龄是"+age);

        System.out.println("请输入您的name");
        String name1 = sc.next();
        System.out.println("您的名字是" + name1);
        System.out.println("欢迎您进入系统");

    }
}
