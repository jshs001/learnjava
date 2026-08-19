package com.itheima1.hello;

import com.itheima1.gaoji2.*;

public class gaoJi2 {
    public static void main(String[] args) {
        System.out.println("1 多态");
        // 概念：多态是在继承/实现情况下的一种现象，表现为：对象多态、行为多态。
        // 具体体现代码如下：
        // People p1 = new Student();  // 对象多态
        // p1.run();  // 行为多态
        // People p2 = new Teacher();  // 对象多态
        // p2.run();  // 行为多态

        People p1 = new Student();
        p1.run(); // 编译看左边 运行看右边： 写p1.run();代码时候 需要看 People p1 里有没有run方法。  执行时候 需要看new Student(); 里有没有run方法。
        People p2 = new Teacher();
        p2.run();
        // 都是人类 但是在不同的对象下run 就表现不一样  这就是多态

        // 多态的前提：有继承/实现关系； 存在父类引用子类对象；存在方法重写；
        // 多态注意事项：多态是对象、行为的多态，java中的属性（成员变量）不谈多态。
        System.out.println(p1.name);
        System.out.println(p2.name); // 输出: people name 对于成员变量 是编译看左边 运行看左边
        // 写p1.name;代码时候 需要看 People p1 里有没有name属性。  执行时候 需要看p1.name 里有没有name属性。

        System.out.println();
        System.out.println("2 多态好处");
        // 好处： 在多态形式下，右边对象是解耦合的，更便于扩展和维护。
        // 例如： People p = new Student(); 右边的Student 可以随时切换为 Teacher、Worker、Doctor等等 而且下面的代码不用改。

        // 定义方法时，使用父类类型的形参，可以接收一切子类对象，扩展性更强、更便利。

        // 多态好处1 ： 右边的Student 可以随时切换为 Teacher、Worker、Doctor等等 而且下面的代码不用改。
        People p3 = new Student();
        p3.run();
        System.out.println("--------------");
        // 多态好处2： 可以使用父类类型的变量为形参，接收一切子类对象
        go(new Student());
        go(new Teacher());

        System.out.println();
        System.out.println("3 多态问题 多态下的类型转换");
        // 问题：多态下不能使用子类的独有功能。
        // p1.study(); // 发现用不了 这就是多态下存在的问题 。 无法直接调用子类独有的方法。
        // p2.teach();

        // 类型转换
        // 自动类型转换： 父类 变量名 = new 子类（）; 例如 People p = new Student();
        // 强制类型转换： 子类 变量名 = (子类) 父类变量; 例如 Student s = (Student) p;

        // 强制类型转换的一个注意事项：
        // 存在继承/实现关系就可以在编译阶段进行强制类型转换，编译阶段不会报错。
        // 运行时，如果发现对象的真是类型与强转后的类型不同，就会抛出ClassCastException异常（类型转换异常报错）。

        // 强制类型转换 只要存在继承/实现关系就可以在编译阶段进行强制类型转换
        Student s = (Student) p1;
        s.study();

        // Teacher t = (Teacher) p1;  // 此时执行就会报错 因为p1不是Teacher类型而是Student类型
        // t.teach();
        // java官方建议 强转之前使用instanceof进行判断,判断当前对象的真实类型，再进行强转。
        if (p1 instanceof Student){
            Student s1 = (Student) p1;
            s1.study();
        }else if (p1 instanceof Teacher){
            Teacher t1 = (Teacher) p1;
            t1.teach();
        }

    }

    // 多态好处2： 可以使用父类类型的变量为形参，接收一切子类对象
    public static void go(People p){
        p.run();
        if (p instanceof Student){
            Student s = (Student) p;
            s.study();
        }else if (p instanceof Teacher){
            Teacher t = (Teacher) p;
            t.teach();
        }
    }
}
