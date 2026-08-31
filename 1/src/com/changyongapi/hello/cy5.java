package com.changyongapi.hello;

import com.changyongapi.cy5.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntToDoubleFunction;

public class cy5 {
    public static void main(String[] args) {
        System.out.println("1 Arrays");
        // 概念：用来操作数组的工具类
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]  toString()方法把数组转换为字符串

        int[] arr1 = Arrays.copyOfRange(arr, 1,4);
        System.out.println(Arrays.toString(arr1)); // [2, 3, 4]  copyOfRange()方法把数组的一部分复制到一个新的数组中 包前不包后

        int[] arr2 = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]  copyOf()方法把数组复制到一个新的数组中

        double[] arr3 = {3.1, 2.2, 1.3, 4.4, 5.5};
        Arrays.setAll(arr3, new IntToDoubleFunction() { // 设置数组的元素
            @Override
            public double applyAsDouble(int value) {
                return arr3[value] * 2;  // 浮点数运算可能出现精度失真的问题 最好用bigdecimal
            }
        });
        System.out.println(Arrays.toString(arr3));

        Arrays.sort(arr3); // 对数组进行排序
        System.out.println(Arrays.toString(arr3));


        System.out.println();
        System.out.println("2 自定义排序");
        // 数组的元素是对象就没办法简单排序了 需要自定义比较器
        Student[] students = new Student[4];
        students[0] = new Student("张三",179.5 ,18);
        students[1] = new Student("李四",160.5 ,19);
        students[2] = new Student("王五",191.5 ,20);
        students[3] = new Student("赵六",182.5 ,21);

        // Arrays.sort(student); // 会报错 复杂数据类型如对象 必须定制比较规则 有两种方式
        // 方式1 让对象的类 实现Comparable接口 然后重写compareTo方法 自己来定制比较规则
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // 方式2 使用sort方法 创建Comparator比较器接口的匿名内部类对象， 然后自己定制比较规则
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // return  s1.getHeight() - s2.getHeight(); // 不能直接用double 会报错 只能用整数比较
//                if (s1.getHeight() > s2.getHeight())
//                    return 1;
//                else if (s1.getHeight() < s2.getHeight())
//                    return -1;
//                else
//                    return 0;
                return Double.compare(s1.getHeight(), s2.getHeight()); // 简化写法
            }
        });
        System.out.println(Arrays.toString(students));


    }
}
