package com.collection.hello;

import com.collection.jh0.Movie;

import java.util.*;
import java.util.function.Consumer;

public class jh0 {
    public static void main(String[] args) {
        System.out.println("1 集合的体系结构");
        // 集合的体系结构：
        //     Collection 代表单列集合，每个元素（数据）只包含一个值。
        //     Map 代表双列集合，每个元素包含两个值（键值对）。

        System.out.println();
        System.out.println("2 Collection 接口");
        // Collection 接口是单列集合的根接口，定义了单列集合的常用方法。

        // Collection<E>的体系结构：
        //     List  添加的元素有序，可重复，有索引。
        //         ArrayList  有序，可重复，有索引。基于数组实现。
        //         LinkedList  有序，可重复，有索引。基于链表实现。
        //     Set   添加到元素无序，不可重复、无索引。
        //         HashSet   无序，不可重复、无索引。基于哈希表实现。
        //             LinkedHashSet  有序，不可重复、无索引。基于哈希表和链表实现。
        //         TreeSet   安装大小默认升序排序，不可重复、无索引。基于哈希表和排序实现。

        // 简单确认一下Collection集合的特点
        ArrayList<String> list = new ArrayList<>();
        list.add("java1");
        list.add("java2");
        list.add("java1");
        list.add("java2");
        System.out.println(list);

        HashSet<String> set = new HashSet<>();
        set.add("java1");
        set.add("java2");
        set.add("java1");
        set.add("java2");
        System.out.println(set);

        System.out.println();
        System.out.println("3 Collection集合的常用方法");
        // Collection是单列集合的祖宗，它规定的方法（功能）是全部单列集合都会继承的。
        Collection<String> c = new ArrayList<>();  // 多态写法

        c.add("java1");  // 添加元素
        c.add("java2");
        c.add("java1");
        c.add("java2");
        System.out.println(c);

        // c.clear(); // 清空集合
        // System.out.println(c);

        System.out.println("集合是否为空：" + c.isEmpty()); // 判断集合是否为空
        System.out.println("集合的大小：" + c.size()); // 集合的大小

        System.out.println("集合是否包含某个元素：" + c.contains("java1")); // 判断集合是否包含某个元素 大小写敏感
        System.out.println("集合是否包含某个元素：" + c.contains("Java1"));

        System.out.println("删除某个元素：" + c.remove("java1")); // 删除某个元素
        System.out.println(c);

        Object[] array = c.toArray(); // 将集合转换为数组 用object接收 因为你也不知道集合里面是什么类型
        String[] array1 = c.toArray(new String[c.size()]); // 强行用String接收 此时要保证集合里面是String类型 否则会出问题
        System.out.println(Arrays.toString(array)); // 打印数组
        System.out.println(Arrays.toString(array1)); // 打印数组

        Collection<String> c1 = new ArrayList<>();
        c1.add("java1");
        c1.add("java2");
        Collection<String> c2 = new ArrayList<>();
        c2.add("java3");
        c2.add("java4");
        c1.addAll(c2); // 将c2集合中的元素添加到c1集合中
        System.out.println(c1);
        System.out.println(c2);

        System.out.println();
        System.out.println("4 Collection集合的遍历");
        // 迭代器概述：迭代器是用来遍历集合的专用方法（数组没有迭代器），在java中迭代器的代表是Iterator
        Collection<String> c3 = new ArrayList<>();
        c3.add("赵敏");
        c3.add("小昭");
        c3.add("素素");
        c3.add("灭绝");
        System.out.println(c3);

        // 使用迭代器遍历集合
        // 1 从集合对象中获取迭代器对象
        Iterator<String> it = c3.iterator();  // 获取迭代器 迭代器默认是在集合第一个元素位置
//        System.out.println(it.next()); // 获取并遍历集合中的元素
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
        // System.out.println(it.next()); // 多取一次会出异常

        // 2 使用循环结合迭代器遍历集合
        while (it.hasNext()) { // 判断集合中是否还有元素
            System.out.println(it.next()); // 获取并遍历集合中的元素
        }

        // 3 增强for循环 可以用来遍历集合或数组，本质就是迭代器遍历集合的简化写法
        for (String s : c3) {  // 快捷写法 c3.for
            System.out.println(s);
        }

        String[] names = {"赵敏", "小昭", "素素", "灭绝"};
        for (String name : names) {  // 快捷写法 names.for
            System.out.println(name);
        }

        // 4 lambda 表达式
//        c3.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        // c3.forEach(s -> System.out.println(s)); // lambda 表达式 简化写法
        c3.forEach(System.out::println); // lambda 表达式 简化写法

        System.out.println();
        System.out.println("5 案例");
        Collection<Movie> movies = new ArrayList<>();
        movies.add(new Movie("《教父》", 9.5, "马龙·白兰度"));
        movies.add(new Movie("《辛德勒的名单》", 9.3, "利华·霍华德"));
        movies.add(new Movie("《乱世佳人》", 9.2, "弗朗西斯·福特·科波拉"));
        movies.add(new Movie("《乱世佳人》", 9.2, "弗朗西斯·福特·科波拉"));
        System.out.println(movies);

        for (Movie movie : movies) {
            System.out.println("电影名称：" + movie.getName());
            System.out.println("电影评分：" + movie.getScore());
            System.out.println("电影演员：" + movie.getActor());
            System.out.println("--------------------");
        }

    }
}


































