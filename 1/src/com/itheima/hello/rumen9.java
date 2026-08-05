package com.itheima.hello;

import com.itheima.rumen9.Food;
import com.itheima.rumen9.FoodOperator;

import java.util.ArrayList;

public class rumen9 {
    public static void main(String[] args) {

        System.out.println("1.arraylist集合");
        // 集合：是一种容器，用来装数据，类似数组。
        // 数组的元素是固定的，集合的元素是可变的。所以开发中用的更多。
        // java的集合种类很多，这里就先学arraylist.

        // 创建集合对象

        ArrayList<String> list = new ArrayList<>(); // 泛型 约束集合中元素的类型 jdk1.7开始可以这样写
        // ArrayList<String> list = new ArrayList<String>(); //老版本写法
        list.add("hello");  // 添加元素 加到末尾
        list.add("world");
        list.add("java");
        // list.add(99);  // 有泛型约束后 就没有办法再放其他类型数据了
        System.out.println(list);

        list.add(0,"java"); // 添加元素 指定索引位置
        System.out.println(list);

        String s1 = list.get(1); // 获取指定索引位置的元素
        System.out.println(s1);

        System.out.println(list.size()); // 获取集合中元素的个数

        System.out.println(list.remove(0)); // 删除指定索引位置的元素 返回删除的元素
        System.out.println(list);

        System.out.println(list.remove("java")); // 删除指定元素 返回boolean 成功删除返回true 失败返回false，如果有相同的元素 删除的是第一个
        System.out.println(list);

        list.set(0,"java");   // 修改指定索引位置的元素 返回修改前的元素
        System.out.println(list);


        System.out.println();
        System.out.println("2.应用案例");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("java入门");
        list1.add("宁夏枸杞");
        list1.add("黑枸杞");
        list1.add("人资");
        list1.add("特级枸杞");
        list1.add("枸杞子");
        System.out.println(list1);

        // 删除包含枸杞的元素
//        for (int i = 0; i < list1.size(); i++) {
//            String s2 = list1.get(i);
//            if (s2.contains("枸杞")) {
//                list1.remove(i);
//                i--;   // 删除元素后索引位置会变，所以这里要减1
//            }
//        }
        for (int i = list1.size()-1 ; i >= 0; i--) { // 方案2 倒序遍历
            String s2 = list1.get(i);
            if (s2.contains("枸杞")) {
                list1.remove(i);
            }
        }
        System.out.println(list1);

        System.out.println();
        System.out.println("3.综合案例");

        // 完成菜品的上架，以及菜品信息浏览功能
        FoodOperator fo = new FoodOperator();
        fo.start();
















    }
}
