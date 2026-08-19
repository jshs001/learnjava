package com.itheima1.gaoji1;

public class Zi extends Fu {
    String name = "Zi";

    public void test() {
        // privateMethod(); // 私有方法不能被子类调用
        defaultMethod(); // 默认方法可以被子类调用
        protectedMethod(); // 保护方法可以被子类调用
        publicMethod(); // 公共方法可以被子类调用
    }

    // 方法重写测试
    @Override
    public void method() {
        System.out.println("Zi method");
    }
    @Override
    public void method(int a , int b ) {
        System.out.println("Zi methodOverride");
    }


    // 测试子类中访问其他成员的特点
    public void showName() {
        System.out.println(name); // 子类对象的成员变量 就近原则
    }

    public void showName1() {
        String name = "局部";
        System.out.println(name); // 局部变量 就近原则
        System.out.println(this.name);  // 加上this就是对象的成员变量了
        System.out.println(super.name); // 加上super就是父类的成员变量了
    }

    public void showMethod() {
        method();
        method(1, 2); // 调用子类的method方法 也是就近原则
        super.method();
        super.method(1, 2); // 调用父类的method方法
    }
}
