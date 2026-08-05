package com.itheima.hello;

public class rumen8 {
    public static void main(String[] args) {
        System.out.println("1 包");
        // 开发有一句话 不要重复造轮子。别人写好的api 我们拿过来用就行。
        // java 语言自带的api 也都是分模块分包管理的。 我们需要了解主要是java.base包下的api。

        // 包：是分门分类管理不同程序的，类似于文件夹，建包有利于程序的管理和维护。
        // 建包的语法格式：package 包名;（java文件最上方写），一般不需要我们操作，idea自动生成。

        // 注意事项:
        // 1. 同一个包下的程序，可以直接访问。
        // 2. 访问其他包下的程序，必须导包才能访问。 （自动导包 有一个配置 文件-》设置-》编辑器-》常规-》自动导包 勾选快速添加清晰的导入）
        // 3. 自己的程序中调用java提供的程序，也先导包才能使用。
        // 


    }
}
