package com.itheima1.hello;

import java.util.ArrayList;

public class gaoji8 {
    public static void main(String[] args) {
        System.out.println("1 泛型");
        // 概念：定义类、接口、方法时，同时声明了一个或者多个类型变量（如：<E>）,称为泛型类、泛型接口、泛型方法、它们统称为泛型。
        //

        ArrayList list = new ArrayList<>();
        list.add("hello");
        list.add(123);
        list.add(3.14);
        list.add(new Cat81());

        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i); // 这里只能用object接收 除非强转 而且cat没法强转成string等
            System.out.println(obj);
        }

        System.out.println("---------------");
//        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<>(); // jdk1.7开始 new后面<>里的数据类型可以省略了
        list2.add("hello");
        list2.add("world");
        list2.add("java");
        for (int i = 0; i < list2.size(); i++) {
            String str = list2.get(i); // 这里可以直接用String接收
            System.out.println(str);
        }


    }
}
class Cat81{}