package com.itheima1.gaoji5;

public interface A1 {
    // 1 默认方法 必须是default修饰(jdk8开始支持)，默认会被public修饰 ; 也叫实例方法，对象的方法，需要实现类的对象来访问。
    public default void defaultMethod() {
        System.out.println("=====默认方法=====");
        privateMethod();// // 实现类对象调用私有方法访问不了；只能在接口其他私有方法或默认方法中调用
    }

    // 2 私有方法：必须使用private修饰(jdk9开始支持) ;也是实例方法，对象的方法。
    private void privateMethod() {
        System.out.println("=====私有方法=====");// // 实现类对象调用私有方法访问不了；只能在接口其他私有方法或默认方法中调用
    }

    // 3 静态方法：必须使用static修饰(jdk8开始支持)，默认会被public修饰 ;通过接口调用静态方法
    public static void staticMethod() {
        System.out.println("=====静态方法=====");
    }
}
