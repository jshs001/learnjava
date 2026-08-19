package com.itheima1.gaoji1;

public class Fu {
    String name = "Fu";

    // 1 私有
    private void privateMethod() {
        System.out.println("privateMethod");
    }

    // 2 默认
    void defaultMethod() {
        System.out.println("defaultMethod");
    }

    // 3 保护
    protected void protectedMethod() {
        System.out.println("protectedMethod");
    }

    // 4 公共
    public void publicMethod() {
        System.out.println("publicMethod");
    }

    // 测试
    public void test() {
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }


    // 方法重写测试
    public void method() {
        System.out.println("Fu method");
    }

    public void method(int a , int b) {
        System.out.println("Fu methodOverride");
    }
}
