package com.itheima.hello;

import java.util.Random;
import java.util.Scanner;

public class rumen8 {
    public static void main(String[] args) {
        System.out.println("1 包");
        // java开发 思想 不要重复造轮子。
        // java api 也是安装模块和包的方式管理的。 我们学java原生api 主要学java.base 即可。

        // 包：就是用来分门别类管理各种不同的程序的，类似文件夹，有利于管理和维护。
        // 建包的语法 package 包名; （见java类文件首行，在idea中都是自动生成的）。
        // 导包用import 包名; （自动导包 有一个配置 文件-》设置-》编辑器-》常规-》自动导包 勾选快速添加清晰的导入）

        // 注意：
        // 1. 同一个包下的程序，可以直接访问。
        // 2. 访问其他包下的程序，必须导包才能访问。
        // 3. 自己的程序中调用java提供的程序，也需要先导包才可以使用。(注意 java.lang包下的程序，不需要导包。)
        // 4. 当访问多个包下类程序，这些类程序名字一样的情况下。只能导入其中一个包（导入多个包会冲突），导入的包直接类名使用即可。
        //    其他的未导入的包，使用包名类名的方式访问。

        System.out.println();
        System.out.println("2 java.lang.string类 字符串处理");

        // 几种创建对象 封装字符串的方式
        String s1 = "hello world"; // 有参构造器 双引号
        System.out.println(s1);

        String s2 = new String(); // 无参构造器
        System.out.println(s2);

        String s3 = new String("hello world"); // 有参构造器 这里是不推荐使用的构造方法 代码被标灰了
        System.out.println(s3);

        char[] chars = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};//字符数组
        String s4 = new String(chars);
        System.out.println(s4);

        byte[] bytes = {104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100}; //字节数组
        String s5 = new String(bytes);
        System.out.println(s5);

        // string 常用方法
        String s6 = "黑马java";
        System.out.println(s6.length()); // 获取字符串长度

        char c = s6.charAt(1);
        System.out.println(c); // 获取指定索引位置的字符

        for (int i = 0; i < s6.length(); i++) {  // 遍历字符串
            char c1 = s6.charAt(i);
            System.out.print(c1+" ");
        }

        System.out.println();
        char[] c3 = s6.toCharArray();  // 字符串转换成字符数组后遍历
        for (int i = 0; i < c3.length; i++) {
            System.out.print(c3[i]+" ");
        }
        System.out.println("----------------------------------");
        String s7 = "黑马";
        String s8 = "黑马";
        System.out.println(s7 == s8); // true 因为
        System.out.println(s7.equals(s8)); // true 这个方法是比较字符内容是否相等

        String s9 = "34AsdF";
        String s10 = "34aSDF";
        System.out.println(s9.equals(s10)); // false 比较内容 不忽略大小写
        System.out.println(s9.equalsIgnoreCase(s10)); // true 忽略大小写 比较内容

        String s11 = "Java是最好的编程语言之一";
        String s12 = s11.substring(0,8); // 截取字符串
        System.out.println(s12);

        String s13 = s11.substring(9); // 截取字符串
        System.out.println(s13);

        String s14 = "这个电影简直是个垃圾，垃圾电影！！";
        String s15 = s14.replace("垃圾", "**"); // 替换字符串
        System.out.println(s15);

        String s16 = "Java是最好的编程语言之一，我爱Java，Java不爱我！";
        System.out.println(s16.contains("java"));  // 判断字符串中是否包含某个字符
        System.out.println(s16.contains("Java"));
        System.out.println(s16.contains("Java2"));

        String s17 = "张三丰";
        System.out.println(s17.startsWith("张")); // 判断字符串是否以某个字符开头
        System.out.println(s17.startsWith("张三"));
        System.out.println(s17.startsWith("张三2"));

        String s18 = "张无忌，周芷若，殷素素，赵敏";
        String[] names = s18.split("，");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        // 注意事项：
        // 1。 String的对象是不可变字符串对象，一旦创建对象，内容不可改变。
        //     我们每次试图改变字符串对象，实际上是产生了新的字符串对象了，变量每次都是指向了新的字符串对象。老的字符串对象内容确实是没有改变的，所以说String是对象是不可变。
        // 2.  通过”“ 创建的字符串对象，会存储到字符串常量池，且相同的字符串只存储一份。
        // 3.  但是通过new方式创建的字符串对象，每new一次都会产生一个新的对象放到堆内存中。
        String s19 = "hello world";
        String s20 = "hello world";
        System.out.println(s19 == s20);

        char[] chars1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        String s21 = new String(chars1);
        String s22 = new String(chars1);
        System.out.println(s21 == s22);

        System.out.println();
        System.out.println("3 String案例");

        // 案例一
        // 1 开发一个登录页面
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            System.out.println("请输入密码：");
            String pwd = sc.next();

            boolean rs = login(name, pwd);
            if(rs){
                System.out.println("登录成功！");
                break;
            }else{
                System.out.println("登录失败！");
            }
        }

        // 案例二
        System.out.println(getCode(4));
        System.out.println(getCode(6));
    }

    // 2 开发一个登录方法，接收用户输入的用户名和密码，判断用户输入的用户名和密码是否正确。
    public static boolean login(String name, String pwd) {
        if ("admin".equals(name) && "123456".equals(pwd)) { // 判断用户输入的用户名和密码是否正确 正确登录名和密码时 admin 123456
        // 另外这里为啥用equals方法 而不用== 因为上面String name = sc.next();会产生堆内存对象，而"admin"是堆常量池的对象，两个对象地址是不相等的。
            return true;
        } else {
            return false;
        }
    }
    // 设计一个方法 返回指定位数的验证码
    public static String getCode(int n) {
        String code = "";
        String data = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(data.length());
            char c = data.charAt(index);
            code += c;
        }
        return code;
    }
}
