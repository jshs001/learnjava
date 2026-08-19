package com.itheima1.hello;

import com.itheima1.gaoji1.*;

import java.util.ArrayList;

public class gaoJi1 {
    public static void main(String[] args) {
        System.out.println("1 继承");
        // 继承：Java中extends关键字 可以让一个类和另一个类建立父子关系
        // 继承特点：子类能够继承父类非私有成员（成员变量 成员方法）
        // 继承后对象的创建：子类的对象是由子类、父类共同完成的。

        B b = new B();
        System.out.println(b.i);
        System.out.println(b.k);
        b.print1();
        b.print3();

        // 继承的好处：代码复用
        // 继承的使用场景:
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setSkill("Java");
        teacher.printInfo();

        System.out.println();
        System.out.println("2 权限修饰符");
        // 概念：用来限制类中的成员（成员变量、成员方法、构造方法、代码块。。。）能够被访问的范围。
        // 权限修饰符：public > protected > 缺省 > private
        // public: 公共的，被所有类访问
        // protected: 保护的，被同包类、不同包子类(注意不是子类对象 子类对象访问不了)访问
        // 缺省: 默认的，被同包类访问
        // private: 私有的，被本类访问

        Fu f = new Fu();
        // f.privateMethod(); // 私有方法不能被子类调用
        // f.defaultMethod(); // 默认方法不能被子类调用
        // f.protectedMethod(); // 保护方法不能被子类调用
        f.publicMethod();

        System.out.println();
        System.out.println("3 单继承 object类");
        // Java中类只支持单继承，即一个类只能继承一个父类
        // 多继承会出现父类方法冲突问题，Java不支持多继承
        // python支持多继承；python是通过mro查找方式解决多继承问题的 从左到右 从下到上查找方法。
        // java中不支持多继承，但支持多层继承 也可以通过接口解决多继承问题。

        a1 a = new a1();
        a.toString(); // 这是object类中的方法

        // java类的祖宗是object类 java中任何类都是直接或间接继承object类的


        System.out.println();
        System.out.println("4 方法重写");
        // 概念：当子类觉得父类中的某个方法不好用，或者无法满足自己的需求时，子类可以重写一个方法名称、参数列表一样的方法，去覆盖父类的这个方法，这就是方法重写。
        // 注意：重写后，方法的访问，java会遵循就近原则。

        Zi zi = new Zi();
        zi.method();
        zi.method(1, 2);

        // 注意事项：
        // 1 重写方法时候 在方法上面加@Override注解 他可以执行java编译器 检查我们重写的方法是否正确；而且可读性也好 一看就知道是重写方法
        // 2 子类重写父类方法时，访问权限必须大于或等于父类方法的访问权限（public > protected > 缺省）
        // 3 重写方法的返回值类型 必须与被重写方法的返回值类型一样 或者范围更小
        // 4 私有方法 静态方法 不能被重写
        // 真实开发场景 基本都是声明不变 重新实现

        // 方法重写的应用场景：
        // 子类重写Object类中的toString方法 以便返回对象的内容
        System.out.println("---------------------");
        Student s = new Student("张三", 18);
        System.out.println(s.toString());

        ArrayList list = new ArrayList();
        list.add("java");
        System.out.println(list); // [java]

        System.out.println();
        System.out.println("5 子类中访问其他成员的特点");
        // 1 在子类方法中访问其他成员（成员变量、成员方法），是依照就近原则的。
        // 查找路线：子类局部范围 -》子类成员范围-》 父类成员范围 都没有就报错

        // 2 如果子父类中出现重名的成员会优先使用子类的，如果此时一定要在子类中使用父类的成员则用super关键字，super.成员变量名 或者 super.成员方法名

        Zi z1 = new Zi();
        z1.showName();
        z1.showName1();
        z1.showMethod();

        System.out.println();
        System.out.println("6 子类构造器的特点");
        // 特点：子类的全部构造器都会先调用父类的构造器，再执行自己。

        // 子类构造器是如何实现调用父类构造器的：
        // 1 默认情况下 子类构造器的第一行代码默认存在super()（写不写都有）; 它会调用父类的无参构造器
        // 2 如果父类没有无参构造器，则我们必须再子类构造器的第一行手写super(...); 指定去调用父类的有参构造器

        Z z = new Z();
        System.out.println("------------");
        Z z2 = new Z(1);

        // 子类构造器的特点 的使用场景
        Teacher1 teacher1 = new Teacher1("张三", 18, "Java");
        System.out.println(teacher1.getName() + " " + teacher1.getAge() + " " + teacher1.getSkill());


        System.out.println();
        System.out.println("7 this(...)调用兄弟构造器");
        student2 s3 = new student2("张三", 18, "家里蹲大学");
        System.out.println(s3.getName() + " " + s3.getAge() + " " + s3.getSchoolName());

        // 需求 如果学生没有填写学校 那么学校默认是 黑马程序员
        student2 s4 = new student2("丽丝", 17);
        System.out.println(s4.getName() + " " + s4.getAge() + " " + s4.getSchoolName());

    }
}

// 支持多层继承
class a1 {};  // 如果一个类没有继承任何类 默认继承Object类的
class b1 extends a1 {}; // b1继承a1 同时b1也继承了Object类
class c1 extends b1 {};

//class d1 extends c1 , b1 {}; // 不支持多继承


// 子类构造器特点

// 父类有无参构造器
//class F {
//    public F() {
//        System.out.println("F() 父类的无参构造器执行了");
//    }
//}
//
//class Z extends F {
//    public Z() {
//        // super(); // 默认存在
//        System.out.println("Z() 子类的无参构造器执行了");
//    }
//    public Z(int i) {
//        // super(); // 默认存在
//        System.out.println("Z(int) 子类的有参构造器执行了");
//    }
//}

// 父类是有参构造器 没有无参构造器
class F {
//    public F() {
//        System.out.println("F() 父类的无参构造器执行了");
//    }
    public F(int i) {
        System.out.println("F(int) 父类的有参构造器执行了");
    } // 此时下面会报错 因为没有无参构造器
}

class Z extends F {
    public Z() {
        // super(); // 默认存在
        super(1); // 调用父类有参构造器  明确一下有参构造器 即可处理报错
        System.out.println("Z() 子类的无参构造器执行了");
    }
    public Z(int i) {
        // super(); // 默认存在
        super(1); // 调用父类有参构造器  明确一下有参构造器 即可处理报错
        System.out.println("Z(int) 子类的有参构造器执行了");
    }
}


// 子类构造器的特点 的使用场景
class Teacher1 extends People1 {
    private String skill;

    public Teacher1(String name, int age, String skill) {
        super(name, age); // 调用父类有参构造器 简化子类构造器的代码
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }


}


class People1 {
    private String name;
    private int age;

    public People1() {
    }
    public People1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


// this（...）调用兄弟构造器
class student2 {
    private String name;
    private int age;
    private String schoolName;

    public student2() {
    }

//    public student2(String name, int age) {
//        this.name = name;
//        this.age = age;
//        this.schoolName = "黑马程序员";
//    }

    public student2(String name, int age) {
        this(name, age, "黑马程序员");  // 这里就是堆上面注释的几行代码的优化
        // super();  // 注意这里不可以加super() , this()调用的构造器里 已经有了一个super()了, 不能出现两次。
                     // 另外this()只能放到第一行 不能放到第二行， super()也只能放到第一行 不能放到第二行;
                     // 总之this()和super()只能选择一个 不能同时存在
    }

    public student2(String name, int age, String schoolName) {
        this.name = name;
        this.age = age;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
