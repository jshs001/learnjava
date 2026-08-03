package com.itheima.hello;

/**
    文档注释 此处会自动录入说明文档中
    注释不影响程序运行 不会编译进class文件 可以把class文件拖到idea中反编译进行查看
 */

public class rumen {
    public static void main(String[] args) {
        System.out.println("java入门语法");
        System.out.println("1 注释");
        // 单行注释 ctrl /
        /*
            多行注释
            多行注释
            ctrl shift /
        */

        System.out.println("2 字面量：常用数据在程序中的书写格式");
        System.out.println(12312);//整数
        System.out.println(99.1);//小数

        System.out.println('a');//字符 单引号是字符
        System.out.println('0');//字符
        System.out.println('中');//字符
        System.out.println(' ');//空字符
        System.out.println('\n');//特殊字符 转义字符 \t \n 等，这里实际会出现两个空行 代码本身的加\n的

        System.out.println("sadfasd  asdfasdf ");//字符串 双引号 里面内容随意 可包含空格

        System.out.println(true);//布尔值
        System.out.println(false);//布尔值

        System.out.println("3 变量：数据类型 变量名称 = 数据;   如 int age = 18;");
        int age =23;
        System.out.println(age);
        age = 25;
        int age1 = age + 1;
        System.out.println(age1);
        double score = 99.5;
        System.out.println(score);
        // 变量要先声明才能使用， java变量一定要注意类型， 注意作用域。

        System.out.println("4 关键字 不能用于类名 函数名 变量名等");
        System.out.println("5 标识符 就是一个名字 如类名 函数名 变量名等");
        // 标识符组成：数字 字母 下划线 和美元符
        // 不能数字开头 不能用关键字 区分大小写
        // 标识符建议 变量名函数名小驼峰 类名称大驼峰




    }
}
