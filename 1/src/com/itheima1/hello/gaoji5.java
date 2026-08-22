package com.itheima1.hello;

import com.itheima1.gaoji1.Zi;
import com.itheima1.gaoji5.A1;
import com.itheima1.gaoji5.B1;
import com.itheima1.gaoji5.ClassManager;
import com.itheima1.gaoji5.D;

public class gaoji5 {
    public static void main(String[] args) {
        System.out.println("1 接口");
        // 概念： interface关键字修饰；接口中的成员变量就是常量，成员方法就是抽象方法。

        // 接口不能创建对象，不能有构造方法、非抽象方法和代码块。是用来继承的，实现接口的类称实现类。

        // 一个类可以实现多个接口（理解为可以有多个干爹），实现类必须重写完全部接口的全部抽象方法，否则实现类需要定义成抽象类。

        D d = new D();
        d.test();
        d.testb1();
        d.testb2();
        d.testc1();
        d.testc2();

        // 接口的好处：
        // 弥补了java单继承的不足，一个类同时可以实现多个接口
        // 让程序员可以面向接口编程，这样程序员就可以灵活方便的切换各种业务实现
        Driver a1 = new A51();
        Singer a2 = new A51();
        A51 a3 = new A51();
        a3.drive();
        a3.sing();

        // 面向接口编程 跟多态一样
        Driver b1 = new B51(); // 这里是Driver类型: new B1() 随时可以切换为其他实现类 如new A1()
        b1.drive();

        System.out.println();
        System.out.println("2 面向接口编程 综合案例");
        ClassManager classManager = new ClassManager();
        classManager.printInfo();
        classManager.printAverageScore();

        System.out.println();
        System.out.println("3 接口的其他细节");
        // 1 默认方法 必须是default修饰(jdk8开始支持)，默认会被public修饰 ; 也叫实例方法，对象的方法，需要实现类的对象来访问。
        B1 b2 = new B1();
        b2.defaultMethod();
        // 2 私有方法：必须使用private修饰(jdk9开始支持);也是实例方法，对象的方法。
        // b2.privateMethod(); // 实现类对象调用私有方法访问不了；只能在接口其他私有方法或默认方法中调用
        // 3 静态方法：必须使用static修饰(jdk8开始支持)，默认会被public修饰 ;通过接口调用静态方法
        A1.staticMethod();

        // 接口新增了三种带方法体的方法：增强了接口能力，便于扩展和维护

        System.out.println();
        System.out.println("4 接口的多继承");
        // 概念：一个接口可以同时继承多个接口；interface C extends A, B {}
        // 好处：便于实现类实现。

        // 注意事项：
        // 1 一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承。
        // 2 一个类实现多个接口，如果多个接口中存在方法签名冲突，则此时不支持多实现。
        // 3 一个类继承了父类，又同时实现了接口，父类和接口中有同名的默认方法，实现类会优先用父类的。
        Zi51 zi51 = new Zi51();
        zi51.run();
        // 4 一个类实现了多个接口，多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可。
        It3 it3 = new It3();
        it3.test1();

    }
}

// 弥补了java单继承的不足，一个类同时可以实现多个接口

class A51 extends Student51 implements Driver, Singer {
    @Override
    public void drive() {
        System.out.println("A1 drive");
    }
    @Override
    public void sing() {
        System.out.println("A1 sing");
    }
};

class Student51 {}

interface Driver {
    void drive();
}

interface Singer {
    void sing();
}


// 面向接口编程
class B51 implements Driver{
    @Override
    public void drive() {
        System.out.println("B1 drive");
    }
}

// 接口的多继承
interface A52{
    void test1();
}
interface B52{
    void test2();
}
interface C1 extends A52, B52{

}
class D52 implements C1{ //需要实现全部抽象方法
    @Override
    public void test1() {

    }
    @Override
    public void test2() {

    }
}

// 1 一个接口继承多个接口，如果多个接口中存在方法签名冲突，则此时不支持多继承。
interface i {
    void test1();
}
interface j {
    String test1();
}
//interface k extends i, j{ // test1()方法签名冲突： 一个有返回值 一个没有返回值
//}

// 2 一个类实现多个接口，如果多个接口中存在方法签名冲突，则此时不支持多实现。
//class E implements i ,j{} // test1()方法签名冲突： 一个有返回值 一个没有返回值

// 3 一个类继承了父类，又同时实现了接口，父类和接口中有同名的默认方法，实现类会优先用父类的。
class fu{
    public void run(){
        System.out.println("父类的 run");
    }
}
interface fu1{
    default void run(){
        System.out.println("接口的 run");
    }
}
class Zi51 extends fu implements fu1{
}

// 4 一个类实现了多个接口，多个接口中存在同名的默认方法，可以不冲突，这个类重写该方法即可。
interface It1 {
    default void test1(){
        System.out.println("It1 test1");
    }
}
interface It2 {
    default void test1(){
        System.out.println("It2 test1");
    }
}
class It3 implements It1, It2{
    @Override
    public void test1() {
        System.out.println("It3 test1");
    }
}
















