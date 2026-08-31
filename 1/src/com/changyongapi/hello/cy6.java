package com.changyongapi.hello;

import com.changyongapi.cy5.Student;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

public class cy6 {
    public static void main(String[] args) {
        System.out.println("1 lambda");
        // lambda表达式：jdk8新增 用于简化匿名内部类的代码写法
//        Animal animal = new Animal() {
//            @Override
//            public void run() {
//                System.out.println("狗跑的贼快 ~~");
//            }
//        };
//        animal.run();

        // Animal animal = () -> System.out.println("狗跑的贼快 ~~"); // 这里简化会报错 因为lambda表达式只支持函数式接口的匿名内部类
        // animal.run();


        // 函数式接口： 有且仅有一个抽象方法的接口
        // 大部分函数式接口都有@FunctionalInterface注解， 有该注解的接口必须是函数式接口，否则编译会报错
        Swimming s = new Swimming() {
            @Override
            public void swim() {
                System.out.println("狗游的贼快 ~~");
            }
        };
        s.swim();

        Swimming s1 = () -> System.out.println("狗1游的贼快 ~~");
        s1.swim();

        System.out.println();
        System.out.println("2 lambda简化规则");
        // 1 参数类型可以省略不写
        // 2 如果只有一个参数，参数类型可以省略，同时（）也可以省略
        // 3 如果lambda表达式的方法体代码只有一行代码，可以省略大括号不写，同时要省略分号，此时如果这行代码是return语句，则return关键字可以省略
        double[] arr3 = {3.1, 2.2, 1.3, 4.4, 5.5};
//        Arrays.setAll(arr3, new IntToDoubleFunction() { // 设置数组的元素
//            @Override
//            public double applyAsDouble(int value) {
//                return arr3[value] * 2;  // 浮点数运算可能出现精度失真的问题 最好用bigdecimal
//            }
//        });
        Arrays.setAll(arr3, value -> arr3[value] * 2);
        System.out.println(Arrays.toString(arr3));

        Student[] students = new Student[4];
        students[0] = new Student("张三",179.5 ,18);
        students[1] = new Student("李四",160.5 ,19);
        students[2] = new Student("王五",191.5 ,20);
        students[3] = new Student("赵六",182.5 ,21);
        Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
        System.out.println(Arrays.toString(students));
    }
}
interface Swimming {
    void swim();
}


abstract class Animal {
    public abstract void run();
}