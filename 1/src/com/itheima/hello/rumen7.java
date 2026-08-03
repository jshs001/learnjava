package com.itheima.hello;

import com.itheima.rumen7.Student;
import com.itheima.rumen7.Student1;
import com.itheima.rumen7.Teacher;

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
        s7.setChinese(80);
        s7.setMath(90);
        System.out.println(s7.getName() + " " + s7.getChinese() + " " + s7.getMath());

        System.out.println();
        System.out.println("5 实体类：就是一种特殊形式的类");
        // 实体类：这个类中的成员变量都有私有，且都要对外提供getXxx、setXxx方法。类中必须有一个公共的无参构造器。






    }
}
