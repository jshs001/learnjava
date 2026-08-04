package com.itheima.hello;

import com.itheima.rumen7.*;

import java.util.Scanner;

public class rumen7 {
    private static Student1Operator so;

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

        System.out.println();
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

        System.out.println();
        System.out.println("3 构造器");
        // 构造器：是一种特殊的成员方法，用于创建对象并初始化对象。有了构造器就可以在创建对象的时候 同时初始化对象数据了。
        // Student s5 = new Student();创建对象时 new Student()会调用构造器执行 。  构造器也支持方法重载，构造器的名称必须与类名一致。
        // 构造器：分为无参构造器和有参构造器。
        Student s5 = new Student();
        Student s6 = new Student("张三", 80, 90);

        // 类在设计时 如果不写构造器 Java自动会给生成一个无参构造器
        // 一旦定义了有参构造器 Java就不会自动生成无参构造器了 此时建议手动写个无参构造器
        // 验证时候： 可以把项目物理目录out下对应的类class文件 拖到idea里 反编译查看
        Teacher t1 = new Teacher();

        System.out.println();
        System.out.println("4 封装：面向对象的三大特征之一");

        // 封装：用类来设计对象处理一个事务的数据时，应该把处理的数据和处理这些数据的方法，设计到一个对象中去。
        // 如 上面的学生类 类中封装了学生的数据和处理学生数据的方法。

        // 注意封装的设计规范：合理隐藏、合理暴露。
        // 好比汽车 设计时隐藏了发动机和各种底层，只暴露方向盘、油门、刹车等。
        // 所谓的公开和隐藏 对应是java的权限修饰符 public private 等。
        // 隐藏后的成员通过 对象名.成员变量名或方法的方式 就访问不到了。 但是可以暴露符合业务的方法来修改成员。
        // 合理暴露合理隐藏的代价是代码多了，好处是对象设计安全可靠了。

        Student1 s7 = new Student1();
        s7.setName("张三");// 这里s7.name = "张三"执行不了 只能用setter方法
        s7.setScore(80);
        System.out.println(s7.getName() + " " + s7.getScore());

        System.out.println();
        System.out.println("5 实体类：就是一种特殊形式的类");
        // 实体类：这个类中的成员变量都有私有，且都要对外提供getXxx、setXxx方法。类中必须有一个公共的无参构造器。
        // 实体类就是保存某个事物的数据的。只有成员变量，构造器和getter、setter方法。

        // 实体类和封装不一样，封装的方法会很多，实体类只有构造器和getter、setter方法。Student1 就是一个实体类。
        Student1 s8 = new Student1();
        s8.setName("张三");
        s8.setScore(80);
        System.out.println(s8.getName() + " " + s8.getScore());

        // 应用场景：实体类只负责数据存取，而对数据的处理交给其他类来完成。实现数据和数据业务处理相分离。
        Student1 s9 = new Student1("老六", 80);
        Student1Operator so = new Student1Operator(s9);
        so.printPass();

        System.out.println();
        System.out.println("6 案例 模仿电影信息系统");
        Movie[] movies = new Movie[4];
        movies[0] = new Movie(1, "唐顿庄园", 9.5, 9.5, "罗伯·罗素", "杰森·斯坦森", "一部美国1990年的电影");
        movies[1] = new Movie(2, "唐顿庄园2", 9.5, 9.5, "罗伯·罗素", "杰森·斯坦森", "一部美国1990年的电影");
        movies[2] = new Movie(3, "唐顿庄园3", 9.5, 9.5, "罗伯·罗素", "杰森·斯坦森", "一部美国1990年的电影");
        movies[3] = new Movie(4, "唐顿庄园4", 9.5, 9.5, "罗伯·罗素", "杰森·斯坦森", "一部美国1990年的电影");

        MovieOperator mo = new MovieOperator(movies);
        mo.printAllMovies();
        mo.searchMovieById(3);

        Scanner sc = new Scanner(System.in);
        loop:while (true) {
            System.out.println();
            System.out.println();
            System.out.println("==电影信息系统==");
            System.out.println("1. 显示所有电影信息");
            System.out.println("2. 根据编号查询电影信息");
            System.out.println("3. 退出");
            System.out.println("请输入操作命令");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    mo.printAllMovies();
                    break;
                case 2:
                    System.out.println("请输入编号");
                    int id = sc.nextInt();
                    mo.searchMovieById(id);
                    break;
                case 3:
                    System.out.println("谢谢使用");
                    break loop;
                default:
                    System.out.println("输入错误");
            }
        }

        System.out.println();
        System.out.println("7 成员变量和局部变量的区别");
        // 1 类中位置不同：成员变量（类中 方法外）、局部变量（常见于方法中）。
        // 2 初始化值不同：成员变量（有默认值 不需要初始化赋值）、局部变量（没有默认值 使用前必须完成赋值）。
        // 3 内存位置不同：成员变量（存在堆内存）、局部变量（栈内存）。
        // 4 作用域不同：成员变量（整个对象）、局部变量（在所属的大括号中）。
        // 5 生命周期不同：成员变量（与对象同生死）、局部变量（方法调用而生，方法结束而死）。
        // 6 如果在类的成员方法中不想用局部变量，想用对象的成员变量，那么就可以用this关键字。

    }
}
