package com.itheima.hello;

import com.itheima.rumen7.Student;

public class rumen7 {
    public static void main(String[] args) {
        System.out.println("1 面向对象编程 快速入门");

        Student s1 = new Student();
        s1.name = "张三";
        s1.chinese = 80;
        s1.math = 90;
        s1.pringTotalScore();
        s1.printAvgScore();

        Student s2 = new Student();
        s2.name = "李四";
        s2.chinese = 90;
        s2.math = 89;
        s2.pringTotalScore();
        s2.printAvgScore();

        System.out.println(s1);
        System.out.println(s2);

        // 万物皆对象 是java思想；
        // 对象的本质就是一种特殊的数据结构。
        // class就是类 就是对象的数据结构

        // 类与对象的注意事项
        // 1 类名建议大驼峰 且具有意义
        // 2 类定义的变量也成为成员变量（对象的属性）； 类中定义的方法也称成员方法（对象的行为）。
        // 3 类的成员变量本身是存在默认值的。定义时候注意不要赋初始值，因为没有意义。
        // 4 一个代码中（class文件）可以定义多个类，但只能有一个public类，且名称必须与文件名一致。
        // 5 对象与对象之间的数据不会相互影响 但是多个变量指向一个对象时就会相会影响了
        // 6 如果某个对象没有一个变量引用它 则该对象无法被操作了 该对象会成为所谓的垃圾对象。 java存在垃圾回收机制 会自动清楚 不用考虑。

        System.out.println("2 this: 就是一个变量 可以用在方法中 来拿到当前对象；哪个对象调用方法 this就指向哪个对象");
        Student s3 = new Student();
        System.out.println(s3);
        s3.printThis();  // this指向的就是对象的地址

        // this 主要用来解决变量名称冲突的问题
        Student s4 = new Student();
        s4.name = "王五";
        s4.score = 325;
        s4.printPass(250); // 详见此方法的定义 this.score > score ; this.score是对象的属性 而score是形参
        // 其实类定义中的成员方法 如printPass或printThis方法 都有一个隐藏的默认形参 就是this ，所以方法里面都可以直接用this。


    }
}
