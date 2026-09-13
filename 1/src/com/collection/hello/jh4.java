package com.collection.hello;

import com.collection.jh2.Student;
import com.collection.jh4.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class jh4 {
    public static void main(String[] args) {
        System.out.println("1 可变参数");
        // 可变参数：一种特殊形参，定义在方法、构造器的形参列表里，格式是：数据类型...参数名称；
        // 特点：可以不传数据给它；可以传一个或同时传多个数据给它；也可以传一个数组给它；
        // 好处：常常用来灵活的接收数据；（可变参数在方法内部，本质就是一个数组）

        test();
        test(1);
        test(1, 2, 3);
        test(new int[]{1, 2, 3});

        // 注意：
        // 1 一个形参列表中，只能有一个可变参数
        // 2 可变参数必须放到形参列表的最后面
        // 3 可变参数在方法内部，本质就是一个数组

        System.out.println();
        System.out.println("2 Collections工具类:操作集合的工具类");
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "张三", "李四", "王五"); // 添加多个元素
        System.out.println(names);

        Collections.shuffle(names); // 随机排序
        System.out.println(names);

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 71, 21, 13, 54, 15);
        Collections.sort(numbers); // 排序
        System.out.println(numbers);

        List<Student> students = new ArrayList<>();
        students.add(new Student("牛魔王", 38, 1.75));
        students.add(new Student("白骨", 59, 1.65));
        students.add(new Student("沙僧", 20, 1.85));

        //Collections.sort(students); // 没有实现比较规则 所以报错
        Collections.sort(students, (s1, s2) -> s1.getAge() - s2.getAge()); // 自定义比较器（同时存在优先级高）； 或者类中继承Comparable接口并重写compareTo方法
        System.out.println(students);

        System.out.println();
        System.out.println("3 斗地主案例");

        Room m = new Room();
        m.start();

    }

    public static void test(int... nums) {
        // 可变参数在方法内部，本质就是一个数组
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println("-----------");
    }
}
